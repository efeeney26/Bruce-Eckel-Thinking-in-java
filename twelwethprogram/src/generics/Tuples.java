package generics;
import static generics.util.Print.*;

class ThreeTuple<A,B,C> extends TwoTuple<A,B>{
    public final C third;
    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        third = c;
    }
    public String toString() {return "(" + first + ", " + second + ", " + third +")" ;}
}

class FourTuple<A,B,C,D> extends ThreeTuple<A,B,C>{
    public final D fourth;
    public FourTuple(A a, B b, C c, D d) {
        super(a, b, c);
        fourth = d;
    }
    public String toString() {return "(" + first + ", " + second + ", " + third + ", " + fourth + ")" ;}
}

class FiveTuple<A,B,C,D,E> extends FourTuple<A,B,C,D>{
    public final E fiveth;
    public FiveTuple(A a, B b, C c, D d, E e) {
        super(a, b, c, d);
        fiveth = e;
    }
    public String toString() {return "(" + first + ", " + second + ", " + third + "," + fourth + ", " + fiveth + ")" ;}
}