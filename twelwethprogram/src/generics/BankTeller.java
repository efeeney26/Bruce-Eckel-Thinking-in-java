package generics;
import java.util.*;

import static generics.util.Print.*;
//простая имитация банковского обслуживания

class Customer {
    private static long counter = 1;
    private final long id = counter++;
    private Customer() {}
    public String toString() {return "Customer " + id;}
    //метод для получения объектов Generator
    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}

class Teller {
    private static long counter = 1;
    private final long id = counter++;
    private Teller() {}
    public String toString() {return "Customer " + id;}
    //синглетный объект Generator
    public static Generator<Teller> generator =
        new Generator<Teller>() {
            @Override
            public Teller next() {
                return new Teller();
            }
        };
}

public class BankTeller {
    public static void serve(Teller t, Customer c) {
        print(t + " обслуживает " + c);
    }
    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<Customer> line = new LinkedList<Customer>();
        Generators.fill(line, Customer.generator(), 15);
        List<Teller> tellers = new ArrayList<Teller>();
        Generators.fill(tellers, Teller.generator, 4);
        for (Customer c : line) {
            serve(tellers.get(rand.nextInt(tellers.size())), c);
        }
    }
}
