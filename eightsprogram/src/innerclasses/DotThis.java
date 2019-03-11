package innerclasses;
import static innerclasses.util.Print.*;

public class DotThis {
    void f() {print("DotThis.f()");}
    public class Inner {
        public DotThis outer() {
            return DotThis.this;
        }
    }
    public Inner inner(){return new Inner();}
    public static void main(String[] args) {
        DotThis dt = new DotThis();//создали объект класса DotThis
        DotThis.Inner dti = dt.inner();//создали объект класса Inner
        dti.outer().f();//вызвали метод outer, который возвращает объект класса DotThis и вызвываем метод f()
    }
}
