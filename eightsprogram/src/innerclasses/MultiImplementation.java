package innerclasses;
import static innerclasses.util.Print.*;
//При использовании реальных или абстрактынх классов "множественное наследование реализации" возможно только с применением внутренних классов

class D {
    public String toString() {return getClass().getSimpleName();}
}
abstract class E {}

class Z extends D {
    E makeE() {return new E() {};}//синтаксис для создания экземпляра интерфейсов и абстрактных классов
}

public class MultiImplementation {
    static void takesD(D d) {print(d);}
    static void takesE(E e) {print(e);}
    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());
    }

}
