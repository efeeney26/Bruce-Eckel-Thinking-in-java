package multithreading;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static multithreading.util.Print.*;
//создание ограниченного набора потоков для выпонения переданных задач

public class FixedThreadPool {
    public static void main(String[] args) {
        //Аргумент конструктора - кол-во потоков
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            es.execute(new LiftOff());
        }
        es.shutdown();
    }
}
