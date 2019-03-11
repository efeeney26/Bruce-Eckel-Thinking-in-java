package multithreading;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static multithreading.util.Print.*;
//тостер с использованием очередей

class Toast {
    public enum Status {DRY, BUTTERED, JAMMED}
    private Status status = Status.DRY;
    private final int id;

    public Toast(int id) {
        this.id = id;
    }
    public void butter() {status = Status.BUTTERED;}
    public void jam() {status = Status.JAMMED;}

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast: " + id + ": " + status;
    }
}

class ToastQueue extends LinkedBlockingQueue<Toast> {}
class Toaster implements Runnable {
    private ToastQueue toastQueue;
    private int count = 0;
    private Random rand = new Random(47);

    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));//приготовление тоста
                Toast t = new Toast(count++);
                print(t);
                toastQueue.add(t);//вставка в очередь
            }
        }catch (InterruptedException e) {
            print("Toaster interrupted");
        }
        print("Toaster off");
    }
}

class Butterer implements Runnable {
    private ToastQueue dryQueue, butteredQueue;

    public Butterer(ToastQueue dryQueue, ToastQueue butteredQueue) {
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //блокирует до готовности следующего тоста
                Toast t = dryQueue.take();
                t.butter();
                print(t);
                butteredQueue.put(t);
            }
        }catch (InterruptedException e) {
                print("Butterer interrupted");
        }
        print("Butterer off");
    }
}
//Нанесение джема на тост с маслом
class Jammer implements Runnable {
    private ToastQueue butteredQueue, finishedQueue;

    public Jammer(ToastQueue butteredQueue, ToastQueue finishedQueue) {
        this.butteredQueue = butteredQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //блокирует до готовности следующего тоста
                Toast t = butteredQueue.take();
                t.jam();
                print(t);
                finishedQueue.put(t);
            }
        }catch (InterruptedException e) {
            print("Jammer interrupted");
        }
        print("Jammer off");
    }
}
//потребление тоста
class Eater implements Runnable {
    private ToastQueue finishedQueue;
    private int counter = 0;

    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //блокирует до готовности следуюего тоста
                Toast t = finishedQueue.take();
                //проверить, что тосты следуют по порядку  и все тосты намазаны джемом
                if(t.getId() != counter++ || t.getStatus() != Toast.Status.JAMMED) {
                    print(">>> Error: " + t);
                }
            }
        }catch (InterruptedException e) {
            print("Eater interrupted");
        }
        print("Eater off");
    }
}
public class ToastOMatic {
    public static void main(String[] args) throws Exception{
        ToastQueue dryQueue = new ToastQueue(),
                butteredQueue = new ToastQueue(),
                finishedQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue, butteredQueue));
        exec.execute(new Jammer(butteredQueue, finishedQueue));
        exec.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
