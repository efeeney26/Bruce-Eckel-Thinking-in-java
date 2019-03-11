package multithreading;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static multithreading.util.Print.*;
//обедающий философ
public class Philosopher implements Runnable{
    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;
    private Random rand = new Random(47);
    private void pause() throws InterruptedException {
        if(ponderFactor == 0) return;
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor) * 250);
    }

    public Philosopher(Chopstick left, Chopstick right, int id, int ponderFactor) {
        this.left = left;
        this.right = right;
        this.id = id;
        this.ponderFactor = ponderFactor;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                print(this + " thinking");
                pause();
                //философ проголодался
                print(this + "grabbing right");
                right.take();
                print(this + "grabbing left");
                left.take();
                print(this + " eating");
                pause();
                right.drop();
                left.drop();
            }
        }catch (InterruptedException e) {
            print(this + " exiting via interrupt");
        }
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                "id=" + id +
                '}';
    }
}
