package collectionobj;
import java.util.*;
import static collectionobj.util.Print.*;

public class CrossContainerIteration {
    public static void display(Iterator<Integer> it) {
        while (it.hasNext()) {
            Integer i = it.next();
            printnb(i+ ", ");
        }
        print();
    }
    public static void main() {
        ArrayList<Integer> numbers = MakeArrayList.arrayList(8);
        LinkedList<Integer> numbersLL = new LinkedList<Integer>(numbers);
        HashSet<Integer> numbersHS = new HashSet<Integer>(numbers);
        TreeSet<Integer> numbersTS = new TreeSet<Integer>(numbers);
        display(numbers.iterator());
        display(numbersLL.iterator());
        display(numbersHS.iterator());
        display(numbersTS.iterator());
    }
}
