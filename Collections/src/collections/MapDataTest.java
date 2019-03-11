package collections;
import java.util.Iterator;
import static collections.util.Print.*;
//тест заполнения Map
class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {
    private int size = 9;
    private int number = 1;
    private char letter = 'a';
    @Override
    public Pair<Integer, String> next() {
        return new Pair<Integer, String>(number++, "" + letter++);
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }
            @Override
            public Integer next() {
                return number++;
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

public class MapDataTest {
    public static void main(String[] args) {
        print(MapData.map(new Letters(), 11));//один генератор Pair
        print(MapData.map(new Government(), new Integers(7), 7));//два разных генератора
        print(MapData.map(new Integers(10), "lol", 10));//генератор ключа и одно значение
        print(MapData.map(new Letters(), new Integers(10)));//Iterable и генератор значения
        print(MapData.map(new Letters(), true));//Iterable и одно значение
    }
}
