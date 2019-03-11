package multithreading;
import static multithreading.util.Print.*;
//простейшее использование класса Thread

public class BasicThreads {
    public static void main(String[] args) {
        Thread thread = new Thread(new LiftOff());
        thread.start();
        print("Waiting for LiftOff");
    }
}
