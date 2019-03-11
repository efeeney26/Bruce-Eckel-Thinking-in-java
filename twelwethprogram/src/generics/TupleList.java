package generics;
import java.util.ArrayList;

import static generics.util.Print.*;
//построение сложных параметризованных типов путем объединения

public class TupleList <A,B,C,D> extends
        ArrayList<FourTuple<A,B,C,D>> {
    public static void main(String[] args) {
        TupleList<Vehicle,Amphibian,String,Integer> t1 =
            new TupleList<Vehicle,Amphibian,String, Integer>();
        print(t1);
        t1.add(TestTuples.h());
        t1.add(TestTuples.h());
        print(t1.get(0));
    }
}
