package generics;
import java.util.Iterator;
import java.util.Random;
import static generics.util.Print.*;

interface Generator<T> {
    T next();
}


public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = {Latte.class, Mocha.class, Capuccino.class, Americano.class,  Breve.class};
    private static Random rand = new Random(47);
    public CoffeeGenerator() {}
    //для перебора
    private int size = 0;
    public CoffeeGenerator(int size){this.size = size;}
    public Coffee next() {
        try {
            return (Coffee)types[rand.nextInt(types.length)].newInstance();
        }catch (Exception e)
        {
            throw new RuntimeException();
        }
    }
    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;
        public boolean hasNext() {return count > 0;}
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }
        public void remove() {//не реализован
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }
    public static void main() {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            print(gen.next());
        }
        for (Coffee c : new CoffeeGenerator(5) ) {
            print(c);
        }
    }

}

