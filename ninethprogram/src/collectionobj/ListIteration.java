package collectionobj;
import java.util.*;
import static collectionobj.util.Print.*;
//использование listIterator

public class ListIteration {
    public static void main() {
        List<Integer> numbers = MakeArrayList.arrayList(8);
        ListIterator<Integer> it = numbers.listIterator();
        while (it.hasNext())
            printnb(it.next() + ": " + it.nextIndex() + ": " + it.previousIndex() + "; ");
        print();
        //в обратном направлении
        while(it.hasPrevious())
            printnb(it.previous() + ", ");
        print();
        print(numbers);
        it = numbers.listIterator(3);
        while (it.hasNext()) {
            it.next();
            it.set(9);
        }
        print(numbers);
    }
}
