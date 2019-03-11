package generics;
import static generics.util.Print.*;
//хранение объекта в классе Object
public class Holder2 {
    private Object a;
    public Holder2(Object a) {this.a = a;}
    public void set(Object a) {this.a = a;}
    Object getObject() {return a;}
    public static void main() {
        Holder2 h = new Holder2(new Automobile());
        Automobile a = (Automobile)h.getObject();
        h.set("не Automobile");
        String s = (String)h.getObject();
        h.set(3);
        Integer i = (Integer)h.getObject();
        print(s);
        print(i);

    }
}
