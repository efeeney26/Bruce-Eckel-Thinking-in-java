package collectionobj;
import java.util.*;
import static collectionobj.util.Print.*;

public class SimpleCollection {
    public static void main() {
        Collection<Integer> c = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
            c.add(i);
        for (Integer i: c) {
            printnb(i + ", ");
        }
    }
}
