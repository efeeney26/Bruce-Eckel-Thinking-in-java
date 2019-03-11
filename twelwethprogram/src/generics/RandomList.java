package generics;
import static generics.util.Print.*;
import java.util.ArrayList;
import java.util.Random;

//контейнер со случайным выбором элемента
public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<T>();
    private Random rand = new Random(47);
    public void add(T item) {storage.add(item);}
    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }
    public static void main() {
        RandomList<String> rl = new RandomList<String>();
        for (String s : ("The quick brown fox jumped over" + " the lazy brown dog").split(" ")) {
            rl.add(s);
        }
        for (int i = 0; i < 11; i++) {
            printnb(rl.select() + " ");
        }
    }
}
