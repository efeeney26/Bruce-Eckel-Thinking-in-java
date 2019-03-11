package collectionobj;
import java.util.*;
import static collectionobj.util.Print.*;
//использование итератора

public class SimpleIteration {
    public static void main() {
        List<Integer> arrList = MakeArrayList.arrayList(12);
        Iterator<Integer> it = arrList.iterator();
        while (it.hasNext())
        {
            Integer i = it.next();
            printnb(i + ", ");
        }
        print();
        //Более простой способ через обычный цикл foreach
        for (Integer i : arrList)
            printnb(i + ", ");
        print();
        //итератор также способен удалять элементы
        it = arrList.iterator();
        for (int i = 0; i < 6; i++) {
            it.next();
            it.remove();
        }
        print(arrList);
    }
}
