package multithreading;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static multithreading.util.Print.*;
//создание одного потока для всех задач(с возможностью очереди)

public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            es.execute(new LiftOff());
        }
        es.shutdown();
    }
}
