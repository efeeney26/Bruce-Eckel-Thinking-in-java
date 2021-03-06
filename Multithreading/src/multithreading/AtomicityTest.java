package multithreading;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static multithreading.util.Print.*;
//явление атомарности
public class AtomicityTest implements Runnable{
    private int i = 0;

    public int getI() {
        return i;
    }

    private synchronized void evenIncrement() {i++; i++;}


    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true) {
            int val = at.getI();//атомарность
            if(val % 2 != 0) {
                print(val);
                System.exit(0);
            }
        }
    }
}
