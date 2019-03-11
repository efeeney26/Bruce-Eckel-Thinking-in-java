package generics;
import java.util.ArrayList;
import java.util.List;

import static generics.util.Print.*;
//использование метасимволов для параметризованных типов для связи, анаогичной восходящему преобразованию
public class GenericAndCovariance {
    public static void main(String[] args) {
        //Метасимволы обеспечивают ковариантность
        List<? extends Fruit> list = new ArrayList<Apple>();
        //ошибка компиляции: добавление объекта
        //произвольного типа невозможно
        //list.add(new Apple());
        //list.add(new Fruit());
        //list.add(new Object());
        //list.add(new Orange());
        Fruit f = list.get(0);//мы знаем, что возвращается по крайней мере Fruit

    }
}
