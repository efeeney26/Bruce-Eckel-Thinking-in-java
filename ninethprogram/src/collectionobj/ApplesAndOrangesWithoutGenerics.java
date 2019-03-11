package collectionobj;
import static collectionobj.util.Print.*;
import java.util.*;
//Простой пример работы с контейнером
//(компилятор выдает предупреждения)
//{Throws exceptions}

class Apple {
    private static long counter;
    private final long id = counter++;
    public long id() {return id;}
}
class Orange {}

public class ApplesAndOrangesWithoutGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList apples = new ArrayList();//в ArrayList хранятся объекты Object(базовый класс всех классов)
        for (int i = 0; i < 3; i++)
            apples.add(new Apple());
        //не припятствует добавлению объкта Orange
        apples.add(new Orange());
        for (int i = 0; i < apples.size(); i++) {
            long id = ((Apple)apples.get(i)).id();//get выдает ссылку на экземпляр класса Object. Чтобы привести ук другому типо надо явно преобразовать к ссылке на экземпляр класса Apple
            //объект Orange обнаруживается только во время выполнения
            print(id);
        }
    }
}
