package collectionobj;
import java.util.*;
import static collectionobj.util.Print.*;
//map ключа и множества значений
class Person {
    private String name;
    public Person(String name) {this.name = name;}
    public String toString() {return name;}
}

public class MapOfList {
    public static Map<Person, List<? extends Integer>>  intPerson =
                            new HashMap<Person, List<? extends Integer>>();
    static {
        intPerson.put(new Person("John"),
                Arrays.asList(1, 2));
        intPerson.put(new Person("Mark"),
                Arrays.asList(3, 4));
        intPerson.put(new Person("Bill"),
                Arrays.asList(5, 6, 7, 8, 9));
        intPerson.put(new Person("Kyle"),
                Arrays.asList(10, 11));
        intPerson.put(new Person("Summer"),
                Arrays.asList(12));
    }
    public static void main() {
        print("People: " + intPerson.keySet());
        print("Ints: " + intPerson.values());
        for (Person person: intPerson.keySet()) {
            print(person + " has ");
            for (Integer i: intPerson.get(person)) {
                print(" " + i);
            }
        }
    }
}
