package generics;
import static generics.util.Print.*;
import java.util.ArrayList;
import java.util.List;
//параметризация контейнеров
public class GenericWriting {
    static <T> void writeExact(List <T> list, T item) {
        list.add(item);
    }
    static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruits = new ArrayList<Fruit>();
    static void f1() {
        writeExact(apples, new Apple());
        writeExact(fruits, new Apple());
        //writeExact(apples, new Fruit());//ошибка компиляции
        print(fruits);
    }
    static <T> void writeWithWildCard(List<? super T> list, T item) {
        list.add(item);
    }
    static void f2() {
        writeWithWildCard(apples, new Apple());
        writeWithWildCard(fruits, new Apple());
    }

}
