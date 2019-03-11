package generics;
import static generics.util.Print.*;
//простой класс с конструктором по умолчанию

public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;
    public long id() {return id;}
    public String toString() {return "countedObject " + id;}
}
