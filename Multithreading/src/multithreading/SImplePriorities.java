package multithreading;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static multithreading.util.Print.*;
//работа с приоритетами

public class SImplePriorities implements Runnable {
    private int countDown = 5;
    private volatile double d;//Без оптимизации
    private int priority;

    public SImplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            //высокозатратная прерываемая операция
            for (int i = 0; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double)i;
                if(i % 1000 == 0)
                    Thread.yield();
            }
            print(this);
            if(--countDown == 0) return;
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new SImplePriorities(Thread.MIN_PRIORITY));
        exec.execute(new SImplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}
