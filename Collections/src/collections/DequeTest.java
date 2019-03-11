package collections;
//import java.util.Deque;

import java.util.LinkedList;

import static collections.util.Print.*;
//пример использования класса Deque
class Deque<T> {
  private LinkedList<T> deque = new LinkedList<T>();
  public void addFirst(T e) {deque.addFirst(e);}
  public void addLast(T e){deque.addLast(e);}
  public int size(){return deque.size();}
  public T removeFirst() {return deque.removeFirst();}
  public T removeLast() {return  deque.removeLast();}
}

public class DequeTest {
    static void fillTest(Deque<Integer> deque) {
        for (int i = 20; i < 27; i++) {
            deque.addFirst(i);
        }
        for (int i = 50; i < 57; i++) {
            deque.addLast(i);
        }
    }
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        fillTest(deque);
        print(deque);
        while (deque.size() != 0)
            printnb(deque.removeFirst() + " ");
        print();
        fillTest(deque);
        while (deque.size() != 0)
            printnb(deque.removeLast() + " ");
    }
}
