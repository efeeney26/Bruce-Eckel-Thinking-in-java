package multithreading;

import com.sun.rmi.rmid.ExecPermission;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static multithreading.util.Print.*;





public class Main {

    public static void main(String[] args) throws Exception{
	    //new LiftOff().run();//работа с интерфесом Runnable

        //BasicThreads.main(args);//простейшее использование класса Thread

        //MoreBasicThreads.main(args);//добавление новых потоков

        //CachedThreadPool.main(args);//создание одного потока для каждой задачи(Executor.newCachedThreadPool())

        //FixedThreadPool.main(args);//создание ограниченного набора потоков для выпонения переданных задач

        //SingleThreadExecutor.main(args);//создание одного потока для всех задач(с возможностью очереди)

        //CallableDemo.main(args);//работа с Callable

        //SleepingTask.main(args);//Вызов sleep для приостановки

        //SImplePriorities.main(args);//работа с приоритетами

        //SimpleDaemons.main(args);//потоки-демоны не препятствуют завершению программы

        //DaemonFromFactory.main(args);//использование ThreadFactory для создания демонов

        //Daemons.main(args);//потоки демоны порождают других демонов

        //SimpleThread.main(args);//прямое наследование от класса Thread

        //SelfManaged.main(args);//самоуправляемое наследование от Runnable

        //Joining.main(args);//как работает join()

        //ExceptionThread.main(args);//нерабочий перехват исключений

        //CaptureUncaughtException.main(args);//рабочий перехват исключений

        //EvenGenerator.main(args);//коллизии между потоками

        //SynchronizedEvenGenerator.main(args);//упрощение мьютекса с использованием ключевого слова synchronized

        //AtomicityTest.main(args);//явление атомарности

        //SerialNumberChecker.main(args);//операции которые кажутся безопасными без потоков становятся опасными с многопоточностью

        //SyncObject.main(args);//синхронизация с объектом, отличного от this(текущего)

        //ThreadLocalVariableHolder.main(args);//автоматическое выделение собственной памяти каждому потоку

        //OrnamentalGarden.main(args);//завершение задач

        //MultiLock.main(args);//поток может многократно захватывать одну блокировку

        //WaxOMatic.main(args);//простейшее взаимодействие между задачами

        //Restaurant.main(args);//взаимодействие потоков в модели "производитель - потребитель"

        //WaxOMatic2.main(args);//использование объектов Lock и Condition

        //ToastOMatic.main(args);//тостер с использованием очередей

        //DeadLockingDiningPhilosophers.main(args);//демонстрация взаимной блокировки

        //FixedDiningPhilosophers.main(args);//обедающие философы без взаимной блокировки

        //CountDownLatchDemo.main(args);//демо класса CountDownLatch

        //CyclicBarrierDemo.main(args);//демо класса CyclicBarrier

        //PriorityBlockingQueueDemo.main(args);//демо PriorityBLockingQueue

        //BankTellerSimulation.main(args);//использование очередей и многопточной модели

        //ActiveObjectDemo.main(args);//ипользование активных объектов
    }
}
