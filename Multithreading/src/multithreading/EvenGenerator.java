package multithreading;
import static multithreading.util.Print.*;
//коллизии между потоками
public class EvenGenerator extends IntGenerator{
    private  int currentEvenValue = 0;
    @Override
    public int next() {
        ++currentEvenValue;//опасная точка
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
