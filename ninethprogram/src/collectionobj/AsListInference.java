package collectionobj;
import java.util.*;
import static collectionobj.util.Print.*;

class Snow {}
class Powder extends Snow {}
class Light extends Snow {}
class Heavy extends Snow {}
class Crusty extends Snow {}
class Slush extends Snow {}

public class AsListInference {
    public static void main() {
        List<Snow> snow1 = Arrays.asList(
                new Crusty(), new Slush(), new Powder()
        );
        /*for (Snow s: snow1) {
            print(s);
        }*/
        //snow1.add(new Heavy());//вызовет ошибку, т.к. менять размер экземпляра типа List нельзя
        List<Snow> snow2 = Arrays.asList(
                new Light(), new Heavy()
        );
        /*for (Snow s: snow2)
            print(s);*/
        //Collections.addAll работыет нормально
        List<Snow> snow3 = new ArrayList<Snow>();
        Collections.addAll(snow3, new Light(), new Heavy());
        /*for (Snow s: snow3)
            print(s);*/

        //Передача информации посредством уточнения
        //типа аргумента
        List<Snow> snow4 = Arrays.<Snow>asList(//вставляется подсказка, которая сообщает фактический тип объекта List, производимого Arrays.asList()
                new Light(), new Heavy());
        /*for (Snow s: snow4) {
            print(s);
        }*/
    }
}
