package typesinfo;
import static typesinfo.util.Print.*;
//Тестирование класса Class

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    Toy () {}//если закомментить эту строку, строка 40 не сработает и будет исключение "не удалось создать объект"
    Toy (int i) {}
    void f() {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {super(1);}
}

public class ToyTest {
    static void printInfo(Class cc) {
        print("Имя класса: " + cc.getName() + " это интерфейс? {" + cc.isInterface() + "]");
        print("Простое имя: " + cc.getSimpleName());
        print("Каноничное имя: " + cc.getCanonicalName());
    }
    public static void main() {
        Class c = null;
        try {
           c = Class.forName("typesinfo.FancyToy");
        }catch (ClassNotFoundException e) {
            print("Не найден класс FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face: c.getInterfaces()) {
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            //необходим конструктор по умолчанию
            obj = up.newInstance();
        }catch (InstantiationException e) {
            print("Не удалось создать объект");
            System.exit(1);
        }catch (IllegalAccessException e) {
            print("Нет доступа");
            System.exit(1);
        }
        printInfo(obj.getClass());

    }
}
