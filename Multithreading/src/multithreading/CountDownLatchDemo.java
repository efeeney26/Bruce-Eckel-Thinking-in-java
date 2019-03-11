package multithreading;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static multithreading.util.Print.*;
//демо класса CountDownLatch

//выполнение части общей задачи
class TaskPortion implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private Random rand = new Random(47);
    private final CountDownLatch countDownLatch;

    public TaskPortion(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            doWork();
            countDownLatch.countDown();
        } catch (InterruptedException e) {//допустимый способ выхода}
        }
    }
    public void doWork() throws InterruptedException{
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        print(this + " completed");
    }

    @Override
    public String toString() {
        return String.format("%1$-3d", id);
    }
}
//ожидание по CountDownLatch
class WaitingTask implements Runnable {
    private static int counter;
    private final int id = counter++;
    private final CountDownLatch countDownLatch;

    public WaitingTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            print("Latch barrier passed for " + this);
        }catch (InterruptedException e) {
            print(this + " interrupted");
        }
    }

    @Override
    public String toString() {
        return String.format("WaitingTask %1$-3d ", id);
    }
}

public class CountDownLatchDemo {
    static final int SIZE = 100;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        //все должны совместно использовать один объект CountDownLatch
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i = 0; i < 10; i++) {
            exec.execute(new WaitingTask(latch));
        }
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new TaskPortion(latch));
        }
        print("Launched all tasks");
        exec.shutdown();//выход при завершении всех задач
    }
}
