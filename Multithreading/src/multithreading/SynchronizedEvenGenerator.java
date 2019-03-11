package multithreading;
import static multithreading.util.Print.*;
//упрощение мьютекса с использованием ключевого слова synchronized

public class SynchronizedEvenGenerator  extends IntGenerator{
    private int currentValue = 0;

    @Override
    public synchronized int next() {
        ++currentValue;
        Thread.yield();
        ++currentValue;
        return currentValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
