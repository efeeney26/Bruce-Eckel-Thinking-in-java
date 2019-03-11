package collectionobj;
import java.util.*;
import static collectionobj.util.Print.*;
//синтаксис работает с любыми коллекциями
public class ForEachCollection {
    public static void main() {
        Collection<String> cs = new LinkedList<String>();
        Collections.addAll(cs,
                "Take the long way home".split(" "));
        for (String s: cs) {
            print(" " + cs + " ");
        }
    }
}
