package generics;
import java.util.ArrayList;
import java.util.Collection;

import static generics.util.Print.*;
//обобщенный метод заполнения коллекции

public class Generators {
    public static <T> Collection<T> fill(Collection<T> col, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++)
            col.add(gen.next());
        return col;
    }
    public static void main(String[] args) {
        Collection<Coffee> coffee = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
        for (Coffee c : coffee)
            print(c);
    }
}
