package multithreading;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static multithreading.util.Print.*;
//некорректный доступ к ресурсам
public class EvenChecker implements Runnable{

    private IntGenerator intGenerator;
    private final int id;

    public EvenChecker(IntGenerator intGenerator, int id) {
        this.intGenerator = intGenerator;
        this.id = id;
    }


    @Override
    public void run() {
        while (!intGenerator.isCanceled()) {
            int val = intGenerator.next();
            if (val % 2 != 0) {
                print(val + "not even!");
                intGenerator.cancel();//отменяет все объекты EvenChecker
            }
        }
    }

    //Тестирование любого типа IntGenerator
    public static void test(IntGenerator gp, int count) {
        print("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gp, i));
        }
        exec.shutdown();
    }
    //значение по умолчанию для сount
    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}
