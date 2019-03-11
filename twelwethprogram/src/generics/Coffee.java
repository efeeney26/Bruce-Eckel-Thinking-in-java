package generics;
import static generics.util.Print.*;

public class Coffee {
    private static long counter = 0;
    private final long id = counter++;
    public String toString() {
        return getClass().getSimpleName() + " " +id;
    }
}

class Latte extends Coffee {}
class Mocha extends Coffee {}
class Capuccino extends Coffee {}
class Americano extends Coffee {}
class Breve extends Coffee {}