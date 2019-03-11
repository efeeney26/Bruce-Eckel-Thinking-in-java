package multithreading;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import static multithreading.util.Print.*;
//демо PriorityBLockingQueue

class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {

    private Random rand = new Random(47);
    private static int counter;
    private final int id = counter++;
    private final int priority;
    protected static List<PrioritizedTask> sequence = new ArrayList<PrioritizedTask>();

    public PrioritizedTask(int priority) {
        this.priority = priority;
        sequence.add(this);
    }

    @Override
    public int compareTo(PrioritizedTask o) {
        return priority < o.priority ? 1 : (priority > o.priority ? -1 : 0);
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(250));
        }catch (InterruptedException e) {}
        print(this);
    }

    @Override
    public String toString() {
        return String.format("[%1$-3d]", priority) + " Task " + id;
    }
    public String summary() {
        return "(" + id + ":" + priority + ")";
    }
    public static class EndSentiel extends PrioritizedTask {
        private ExecutorService exec;

        public EndSentiel(ExecutorService exec) {
            super(-1);//самый низкий приоритет в программе
            this.exec = exec;
        }

        @Override
        public void run() {
            int count = 0;
            for (PrioritizedTask pt : sequence) {
                printnb(pt.summary());
                if(++count % 5 == 0)
                    print();
            }
            print();
            print(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}
class PrioritizedTaskProducer implements Runnable {
    private Random rand = new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService exec;

    public PrioritizedTaskProducer(Queue<Runnable> queue, ExecutorService exec) {
        this.queue = queue;
        this.exec = exec;//используется для EndSentinel
    }

    @Override
    public void run() {
        //неограниченная очередь, блокировка никогда не происходит
        //заполняем случайными приоритетами
        for (int i = 0; i < 20; i++) {
            queue.add(new PrioritizedTask(rand.nextInt(10)));
            Thread.yield();
        }
            //добавляем высокоприоритетные задания
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.MILLISECONDS.sleep(250);
                queue.add(new PrioritizedTask(10));
            }
            //добавляем задания, начиная с низких приоритетов
            for (int i = 0; i < 10; i++) {
                queue.add(new PrioritizedTask(i));
            }
            //сторож, останавливающий все задачи
            queue.add(new PrioritizedTask.EndSentiel(exec));
        }catch (InterruptedException e) {}
        print("Finished PrioritizedTaskProducer");
    }
}

class PrioritizedTaskConsumer implements Runnable {
    private PriorityBlockingQueue<Runnable> q;

    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> q) {
        this.q = q;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //для запуска задачи используется текущий поток
                q.take().run();
            }
        }catch (InterruptedException e) {}
        print("Finished PrioritizedTaskConsumer");
    }

}

public class PriorityBlockingQueueDemo {
    public static void main(String[] args) {
        Random rand = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<Runnable>();
        exec.execute(new PrioritizedTaskProducer(queue, exec));
        exec.execute(new PrioritizedTaskConsumer(queue));
    }
}
