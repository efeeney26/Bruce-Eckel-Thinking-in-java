package innerclasses;
import static innerclasses.util.Print.*;
//Наследование от внутреннего класса

class WithInner {
    class Inner {}
}

public class InheritInner extends WithInner.Inner {
    //InheritInner не компилируется без конструктора, который объявлен внизу
    InheritInner(WithInner withInner) {
        withInner.super();//при наследовании от внутреннего класса необходимо применять конструкции "ссылкаНаВнешнийКласс.super()" в теле конструктора
    }
    public static void main (String[] args) {
        WithInner withInner = new WithInner();
        InheritInner inheritInner = new InheritInner(withInner);
    }
}
