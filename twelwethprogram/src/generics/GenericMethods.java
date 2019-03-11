package generics;
import java.util.*;

import static generics.util.Print.*;
//параметризованные методы

public class GenericMethods {
    public <T> void f(T x) {
        print(x.getClass().getSimpleName());
    }
    public static <U> String g(U x) {
        try {
            return (String)(U)x;
        }catch (Exception e) {
            throw new RuntimeException();
        }
    }
    public static void main() {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0f);
        gm.f('c');
        gm.f(gm);

        print(g("lol"));
        //print(g(4));
    }
}
