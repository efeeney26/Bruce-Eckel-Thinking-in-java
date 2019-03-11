package generics;
import static generics.util.Print.*;
//хранение объекта с параметризацией
public class Holder3<T> {
    private T a;
    public Holder3(T a) {this.a = a;}
    public void setT(T a) {this.a = a;}
    public T getT() {return a;}
    public static void main() {
        Holder3<Automobile> h = new Holder3<Automobile>(new Automobile());
        Automobile a = h.getT();
        //h.setT("не Automobile");//ошибка
        Holder3<String> h1 = new Holder3<String>(new String("lol"));
        print(h.getT());

    }
}
