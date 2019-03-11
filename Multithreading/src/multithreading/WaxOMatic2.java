package multithreading;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static multithreading.util.Print.*;
//использование объектов Lock и Condition

class Car2 {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean waxOn = false;
    public void waxed() {
        lock.lock();
        try {
            waxOn = true; //готово к полировке
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void buffed() {
        lock.lock();
        try {
            waxOn = false;//готово к нанесению слоя воска
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void waitForWaxing() throws InterruptedException{
        lock.lock();
        try {
            while (waxOn == false)
                condition.await();
        }finally {
            lock.unlock();
        }
    }
    public void waitForBuffing() throws InterruptedException{
        lock.lock();
        try {
            while (waxOn == true)
                condition.await();
        }finally {
            lock.unlock();
        }
    }
}

class WaxOn2 implements Runnable {
    private Car car;

    public WaxOn2(Car car) {

        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                printnb("Wax on!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        }catch (InterruptedException e) {
            print("Exiting via interrupt");
        }
        print("Ending wax on task");
    }
}

class WaxOff2 implements Runnable {
    private Car car;

    public WaxOff2(Car car) {

        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                printnb("Wax off!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        }catch (InterruptedException e) {
            print("Exiting via interrupt");
        }
        print("Ending wax off task");
    }
}


public class WaxOMatic2 {
    public static void main(String[] args) throws Exception{
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff2(car));
        exec.execute(new WaxOn2(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
