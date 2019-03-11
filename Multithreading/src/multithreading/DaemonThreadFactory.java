package multithreading;
import java.util.concurrent.ThreadFactory;
//фабрика потоков-демонов
import static multithreading.util.Print.*;

public class DaemonThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
