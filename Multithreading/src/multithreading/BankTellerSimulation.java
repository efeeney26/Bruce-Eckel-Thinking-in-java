package multithreading;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static multithreading.util.Print.*;
//использование очередей и многопточной модели

//объекты, доступные только для чтения не требуют синхронизации
class Customer {
    private final int serviceTime;

    public Customer(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    @Override
    public String toString() {
        return "[" + serviceTime + "]";
    }
}

//очередь клиентов умеет выводить свое состояние
class CustomerLine extends ArrayBlockingQueue<Customer> {

    public CustomerLine(int maxLineSize) {
        super(maxLineSize);
    }

    @Override
    public String toString() {
        if (this.size() == 0) {
            return "[Empty]";
        }
        StringBuilder result = new StringBuilder();
        for (Customer customer : this) {
            result.append(customer);
        }
        return result.toString();
    }
}

//Случайное добавление клиентов в очередь
class CustomerGenerator implements Runnable {
    private CustomerLine customers;
    private static Random rand = new Random(47);

    public CustomerGenerator(CustomerLine customers) {
        this.customers = customers;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
                customers.put(new Customer(rand.nextInt(1000)));
            }
        }catch (InterruptedException e) {
            print("CustomerGenerator interrupted");
        }
        print("CustomerGenerator terminating");
    }
}

class Teller implements Runnable, Comparable<Teller> {
    private static int counter = 0;
    private final int id = counter++;
    //Клиенты обслуженные за смену
    private int customerServed = 0;
    private CustomerLine customers;
    private boolean servingCustomerLine = true;

    public Teller(CustomerLine customers) {
        this.customers = customers;
    }
    //используется приоритетной очередью
    @Override
    public int compareTo(Teller o) {
        return customerServed < o.customerServed ? -1 : (customerServed == o.customerServed ? 0 : 1);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Customer customer = customers.take();
                TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
                synchronized (this) {
                    customerServed++;
                    while (!servingCustomerLine)
                        wait();
                }
            }
        }catch (InterruptedException e) {
            print(this + "interrupted");
        }
        print(this + "terminating");
    }
    public synchronized void doSmthElse() {
        customerServed = 0;
        servingCustomerLine = false;
    }
    public synchronized void serveCustomerLine() {
        assert !servingCustomerLine: "already serving: " + this;
        servingCustomerLine = true;
        notifyAll();
    }

    @Override
    public String toString() {
        return "Teller" + id + " ";
    }
    public String shortString() {
        return "T" + id;
    }
}

class TellerManager implements Runnable {
    private ExecutorService exec;
    private CustomerLine customers;
    private PriorityQueue<Teller> workingTellers = new PriorityQueue<Teller>();
    private Queue<Teller> tellersDoingOtherThings = new LinkedList<Teller>();
    private int adjustPeriod;
    private static Random rand = new Random(47);

    public TellerManager(ExecutorService exec, CustomerLine customers, int adjustPeriod) {
        this.exec = exec;
        this.customers = customers;
        this.adjustPeriod = adjustPeriod;
        //Начать с одного кассира
        Teller teller = new Teller(customers);
        exec.execute(teller);
        workingTellers.add(teller);
    }
    public void adjustTellerNumber() {
        //система управления -изменяя числа, может выявить
        //проблемы стабильности в управляющем механизме
        //Если очередь слишком длинная, добавить кассира
        if(customers.size() / workingTellers.size() > 2) {
            //если кассиры отдыхают или заимаются другим делом,
            //вернуть одного
            if(tellersDoingOtherThings.size() > 0) {
                Teller teller = tellersDoingOtherThings.remove();
                teller.serveCustomerLine();
                workingTellers.offer(teller);
                return;
            }
            //иначе создать(принять на работу) нового кассира
            Teller teller = new Teller(customers);
            exec.execute(teller);
            workingTellers.add(teller);
            return;
        }
        //если очередь достаточно короткая - убрать кассира
        if(workingTellers.size() > 1 && customers.size() / workingTellers.size() < 2) {
            reassignOneTeller();
        }
        //если очереди нет, достаточно одного кассира
        if(customers.size() == 0)
            while (workingTellers.size() > 1)
                reassignOneTeller();
    }
    //отправить кассира на отдых или другую работу
    private void reassignOneTeller() {
        Teller teller = workingTellers.poll();
        teller.doSmthElse();
        tellersDoingOtherThings.offer(teller);
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(adjustPeriod);
                adjustTellerNumber();
                printnb(customers + "{");
                for (Teller teller : workingTellers) {
                    print(teller.shortString() + " ");
                }
                printnb("}");
            }
        }catch (InterruptedException e) {
            print(this + "interrupted");
        }
        print(this + "terminating");
    }

    @Override
    public String toString() {
        return "TellerManager";
    }
}

public class BankTellerSimulation {
    static final int MAX_LINE_SIZE = 50;
    static final int ADJUSMENT_PERIOD = 1000;

    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        //если очередь слишком длинная - клиенты уходят
        CustomerLine customers = new CustomerLine(MAX_LINE_SIZE);
        exec.execute(new CustomerGenerator(customers));
        //менеджер добавляет и удаляет кассиров по необходимости
        exec.execute(new TellerManager(exec, customers, ADJUSMENT_PERIOD));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
