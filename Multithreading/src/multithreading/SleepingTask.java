package multithreading;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static multithreading.util.Print.*;
//Вызов sleep для приостановки
public class SleepingTask extends LiftOff{
    @Override
    public void run() {
        try {
            while (countDown-- > 0) {
                print(status());
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException e) {
            print("Interrupted");
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
