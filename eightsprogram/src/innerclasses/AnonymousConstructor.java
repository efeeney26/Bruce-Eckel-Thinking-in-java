package innerclasses;
import static innerclasses.util.Print.*;
//создание конструктора для безымянного внутреннего класса
abstract class Base {
    public Base(int i) {
        print("Конструктор Base, i = " + i);
    }
    public abstract void f();
}

public class AnonymousConstructor {
    public static Base getBase(int i) {
        return new Base(i) {
            {print("Инициализация экземпляра");}
            public void f() {
                print("Безымяный f()");
            }
        };
    }
    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();

    }
}
