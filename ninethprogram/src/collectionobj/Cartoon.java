package collectionobj;
import java.util.*;

import static collectionobj.util.Print.*;

interface Generator <T>{
    T next();
}
public class Cartoon {
    public static void main(String[] args) {
        print(5);
        //ArrayList<String> col = (ArrayList<String>) ag.getSequence();

       /* ArrayGenerator ag1 = new ArrayGenerator(new LinkedList<Integer>());
        ag1.fill(3, 3, 6, 7);
        ag1.next();
        LinkedList col1 = (LinkedList) ag1.getSequence();
        print(col1.getFirst());*/
    }
}
