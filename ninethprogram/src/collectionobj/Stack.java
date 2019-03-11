package collectionobj;
import java.util.*;
import static collectionobj.util.Print.*;
//Создание стека из списка LinkedList
public class Stack<T> {
    private LinkedList<T> storage = new LinkedList<T>();
    public void push(T v) {storage.addFirst(v);}
    public T peek() {return storage.getFirst();}
    public T pop() {return storage.removeFirst();}
    public boolean empty() {return storage.isEmpty();}
    public String toString() {return storage.toString();}
}

class StackTest {
    public static void main() {
        Stack<String> stack = new Stack<String>();
        for (String s: "My dog has fleas".split(" "))
            stack.push(s);
        while (!stack.empty())
            printnb(stack.pop() + " ");
    }
}
