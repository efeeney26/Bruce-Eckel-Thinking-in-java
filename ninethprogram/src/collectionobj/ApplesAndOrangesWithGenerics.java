package collectionobj;
import java.util.ArrayList;

import static collectionobj.util.Print.*;
//Работа с контейнером с параметризацией

public class ApplesAndOrangesWithGenerics {
    public static void main() {
        ArrayList<Apple> apples = new ArrayList<Apple>();
        for (int i = 0; i < 3; i++)
            apples.add(new Apple());
        //apples.add(new Orange());теперь компилятором выдается ошибка
        for (int i = 0; i < apples.size(); i++) {
            long id = apples.get(i).id();
            print(id);
        }
        for (Apple a: apples) {
            print(a.id());
        }
    }
}
