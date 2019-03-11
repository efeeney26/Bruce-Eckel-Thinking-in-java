package collectionobj;
import java.lang.reflect.Array;
import java.lang.reflect.Array;
import java.util.*;
import static collectionobj.util.Print.*;
//Добавление групп элементов в объекты Collection
public class AddingGroups {

    public static void main() {
        Collection<Integer> collection =
                new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9};
        //print(moreInts[0]);//у массивов [] стандартный вызов нужного элемента
        collection.addAll(Arrays.asList(moreInts));
        //Работает намного быстрее, но таким способом
        //невозможно сконструировать Collection
        Collections.addAll(collection, 10,11,12,13,14);
        Collections.addAll(collection, moreInts);
        //print(((ArrayList<Integer>)collection).get(0));//у интерфейса Collection нет метода get, поэтому требуется явное преобразование типов
        //Создает сптсок на основе массива
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        //print(list.get(0));//у List есть метод get
        list.set(0, 99);//у метода set первый аргумент - индекс, второй - значение. Изменять значение в List можно
        //print(list);
        //list.add(21);//ошибка времени выполнения - нижележащий
                     //массив не должен изменять в размерах


    }
}
