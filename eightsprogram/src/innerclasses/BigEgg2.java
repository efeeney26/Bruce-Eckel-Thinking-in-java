package innerclasses;
import static innerclasses.util.Print.*;
//Правильное наследование внутреннего класса

class Egg2 {
    protected class Yolk {
        public Yolk() {
            print("Egg2.Yolk()");
        }

        public void f() {
            print("Egg2.Yolk.f()");
        }
    }
    private Yolk yolk = new Yolk();
    public Egg2() {print("new Egg2()");}
    public void insertYolk(Yolk yy) {yolk = yy;}
    public void g() {yolk.f();}
}

public class BigEgg2 extends Egg2{
    public class Yolk extends Egg2.Yolk {
        public Yolk() {print("BigEgg2.Yolk()");}
        public void f() {print("BigEgg2.Yolk.f()");}
    }
    public BigEgg2() {insertYolk(new Yolk());}
    public static void main(String[] args) {
        Egg2 e2 = new BigEgg2();
        e2.g();
    }
}
