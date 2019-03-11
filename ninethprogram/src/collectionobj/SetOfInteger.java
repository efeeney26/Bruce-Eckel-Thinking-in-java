package collectionobj;
import java.util.*;
import static collectionobj.util.Print.*;
//использование контейнера Set

public class SetOfInteger {
    public static void main() {
        Random rand = new Random(47);
        Set<Integer> intset = new HashSet<Integer>();
        for (int i = 0; i < 10000; i++) {
            intset.add(rand.nextInt(30));
        }
        print(intset);
    }
}
