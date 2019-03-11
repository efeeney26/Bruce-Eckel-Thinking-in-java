package generics;
import static generics.util.Print.*;
//концепция кортеж из 2 объектов

public class TwoTuple<A,B> {
    public final A first;
    public final B second;
    public TwoTuple(A a, B b) {first = a; second = b;}
    public String toString() {return "(" + first + ", " + second + ")";}
}

