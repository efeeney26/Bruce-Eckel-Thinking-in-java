package collectionobj;
import java.util.*;
import static collectionobj.util.Print.*;

public class LinkedListFeatures {
    public static void main() {
        LinkedList<Integer> numbers = new LinkedList<Integer>(MakeArrayList.arrayList(5));
        print(numbers);
        //Идентично
        print("numbers.getFirst()" + numbers.getFirst());
        print("numbers.element()" + numbers.element());
        //различие появляется только для пустых списков
        print("numbers.peek()" + numbers.peek());
        //Идентично удаление и возврат первого элемента
        print("numbers.remove()" + numbers.remove());
        print("numbers.removeFirst()" + numbers.removeFirst());
        //различия появляются только для пустых списков
        print("numbers.poll()" + numbers.poll());
        print(numbers);
        numbers.addFirst(9);
        print("After addFirst: " + numbers);
        numbers.offer(9);
        print("After offer: " + numbers);
        numbers.add(9);
        print("After add: " + numbers);
        numbers.addLast(9);
        print("After addLast: " + numbers);
        print("number removeLast(): " + numbers.removeLast());
    }
}
