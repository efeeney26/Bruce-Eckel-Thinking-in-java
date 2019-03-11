package multithreading;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static multithreading.util.Print.*;
//простейшее взаимодействие между задачами

class Car {
    private boolean waxOn = false;
    public synchronized void waxed() {
        waxOn = true;//готово к полировке
        notifyAll();
    }
    public synchronized void buffed() {
        waxOn = false;//готово к нанечению слоя воска
        notifyAll();
    }
    public synchronized void waitForWaxing() throws InterruptedException{
        while (!waxOn)
            wait();
    }
    public synchronized void waitForBuffing() throws InterruptedException{
        while (waxOn)
            wait();
    }
}

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car car) {
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
            print("Exciting via interrupt");
        }
        print("Ending wax on task");
    }
}

class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car car) {
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
            print("Exciting via interrupt");
        }
        print("Ending wax off task");
    }
}

public class WaxOMatic {
    public static void main(String[] args) throws Exception{
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow(); //поработать некоторое время и прервать все задачи
    }
}
