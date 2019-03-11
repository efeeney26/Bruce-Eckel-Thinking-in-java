package collectionobj;
import java.util.*;
import static collectionobj.util.Print.*;
//восходящее преобразование LinkedList в Queue
public class QueueDemo {
    public static void printQ(Queue queue) {
        while (queue.peek() != null)//peek() возвращает начальный элемент не удаляя его из очереди
            printnb(queue.remove() + " ");//удаляет и возвращает начальный элемент из очереди
        print();
    }
    public static void main() {
        Queue<Integer> queue = new LinkedList<Integer>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++)
            queue.offer(rand.nextInt(i + 10));//offer() вставляет элемент в конец очереди
        printQ(queue);
        Queue<Character> gc = new LinkedList<Character>();
        for (char c: "Brontosaurus".toCharArray())
            gc.offer(c);
        printQ(gc);
    }
}
