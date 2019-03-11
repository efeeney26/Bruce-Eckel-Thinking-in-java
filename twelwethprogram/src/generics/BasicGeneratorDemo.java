package generics;
import static generics.util.Print.*;
//Генератор для CountedObject

public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        for (int i = 0; i < 5; i++) {
            print(gen.next());
        }
    }
}
