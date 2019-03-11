package generics;
import static generics.util.Print.*;
//простая параметризация

class Automobile {}

public class Holder1 {
    private Automobile a;
    public Holder1(Automobile a) {this.a = a;}
    Automobile get() {return a;}
}
