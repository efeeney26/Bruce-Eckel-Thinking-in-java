package multithreading;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static multithreading.util.Print.*;
//нерабочий перехват исключений

public class ExceptionThread implements Runnable{

    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        try {
            exec.execute(new ExceptionThread());
        }catch (RuntimeException e) {
            print(e);//этот код выполняться не будет(выход исключения из метода run() сразу передается на консоль)
        }
    }
}
