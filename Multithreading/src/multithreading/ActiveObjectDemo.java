package multithreading;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static multithreading.util.Print.*;
//ипользование активных объектов

public class ActiveObjectDemo {
    private ExecutorService exec = Executors.newSingleThreadExecutor();
    private Random rand = new Random(47);
    //вставка случайной задержки для моелирования времени вычисления
    private void pause(int factor) {
        try {
            TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(factor));
        }catch (InterruptedException e) {
            print("sleep() interrupted");
        }
    }
    public Future<Integer> calculateInt(final int x, final int y) {
        return exec.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                print("starting " + x + " + " + y);
                pause(500);
                return x + y;
            }
        });
    }
    public Future<Float> calculateFloat(final float x, final float y) {
        return exec.submit(new Callable<Float>() {
            @Override
            public Float call() throws Exception {
                print("starting " + x + " + " + y);
                pause(2000);
                return x + y;
            }
        });
    }
    public void shutDown() {exec.shutdown();}

    public static void main(String[] args) {
        ActiveObjectDemo d1 = new ActiveObjectDemo();
        //предотвращает CouncurrentModificationException
        List<Future<?>> results = new CopyOnWriteArrayList<Future<?>>();
        for (int i = 0; i < 5; i++) {
            results.add(d1.calculateInt(i, i));
        }
        for (float i = 0.0f; i < 1.0f; i++) {
            results.add(d1.calculateFloat(i, i));
        }
        print("All async calls made");
        while (results.size() > 0) {
            for (Future<?> f :results ) {
                if(f.isDone()) {
                    try {
                        print(f.get());
                    }catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    results.remove(f);
                }
            }
        }
        d1.shutDown();
    }
}
