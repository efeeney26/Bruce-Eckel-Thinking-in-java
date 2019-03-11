package multithreading;
import java.util.ArrayList;
import java.util.concurrent.*;

import static multithreading.util.Print.*;
//работа с Callable
class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}

public class CallableDemo  {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
            for (Future<String> fs : results) {
                try {
                    //get() blocks until completion
                    print(fs.get());
                }catch (ExecutionException e) {
                    print(e);
                }catch (InterruptedException e) {
                    print(e);
                    return;
                }
                finally {
                    exec.shutdown();
                }
            }
        }
}
