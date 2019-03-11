package innerclasses;
import static innerclasses.util.Print.*;
//вложенные классы могут обращаться ко всем членам всех классов, вкоторых они находятся
class MNA {
    private void f() {print("f()");}
    class A {
        private void g() {print("g()");}
        public class B {
            void h() {
                g();
                f();
            }
        }
    }
}

public class MultiNestingAccess {
    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();//синтаксис при создании объектов внутренних классов произвольного уровня вложенности при создании из другого класса
        MNA.A.B mnaab = mnaa.new B();//синтаксис при создании объектов внутренних классов произвольного уровня вложенности при создании из другого класса
        mnaab.h();
    }
}
