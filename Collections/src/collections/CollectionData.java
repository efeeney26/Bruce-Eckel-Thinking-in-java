package collections;
import java.util.ArrayList;
import static collections.util.Print.*;
//заполнение коллекции с использованием объекта генератора(использование паттерна Адаптер(адаптация Generator к конструктору Collection))
interface Generator<T> {
    T next();
}

public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity) {//заполняет коллекцию нужным кол=ом элементов
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }
    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {//обощенный вспомогатеьный маетод
        return new CollectionData<T>(gen, quantity);
    }
}
