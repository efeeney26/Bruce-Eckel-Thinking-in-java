package collectionobj;
import java.util.*;
import static collectionobj.util.Print.*;
//использование контейнера Map(количество вхождения числа, как значение, число как ключ)

public class Statistics {
    public static void main() {
        Random rand = new Random(47);
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < 10000; i++) {
            int r = rand.nextInt(20);
            Integer freq = m.get(r);//get() возвращает null, если элемент отсутствует в контейнере(т.е. число было сгенерировано впервые),
            //в противном случае возвращает значение Integer, связанное с ключом и последнее увеличивается на один
            m.put(r, freq == null ? 1 : freq + 1);
        }
        print(m);
    }
}
