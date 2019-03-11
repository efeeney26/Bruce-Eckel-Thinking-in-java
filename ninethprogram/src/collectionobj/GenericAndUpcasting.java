package collectionobj;
import java.util.ArrayList;
//работа контейнера с восходящим преобразованием
import static collectionobj.util.Print.*;

class GrannySmith extends Apple {}
class Gala extends Apple {}
class Fuji extends Apple {}
class Braeburn extends Apple {}

public class GenericAndUpcasting {
    public static void main() {
        ArrayList<Apple> apples = new ArrayList<Apple>();
        apples.add(new GrannySmith());
        apples.add(new Gala());
        apples.add(new Fuji());
        apples.add(new Braeburn());
        for (Apple a: apples) {
            print(a);
        }
    }
}
