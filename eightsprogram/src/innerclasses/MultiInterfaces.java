package innerclasses;
import static innerclasses.util.Print.*;
//два способра реализации нескольких интерфейсов

interface A {};
interface B {
    void howdy();
};

class X implements A, B {
    public void howdy() {print("Hello A");}
}
class Y implements A {
    B makeB() {
        //Безымянный внутренний класс
        return new B() {
            public void howdy() {print("Hello B");}
        };
    };
}

public class MultiInterfaces {
    static void takesA(A a) {}
    static void takesB(B b) {}
    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        takesA(x);
        takesA(y);
        takesB(x);
        takesB(y.makeB());
        x.howdy();
        y.makeB().howdy();
    }
}
