package arrays;
import java.util.*;

import static arrays.util.Print.*;


class Person {
    private static int counter = 1;
    private final int id = counter++;
    public String toString() {return getClass().getSimpleName() + " " + id;}
}interface Generator <T> {
    T next();
}
class PerGenerator {
    private PerGenerator() {}
    public static Generator<Person> getObj() {
        return new Generator<Person>() {
            @Override
            public Person next() {
                return new Person();
            }
        };
    }
}
class QueuePerson {
    private static Queue<Person> result;
    public static Collection<Person> createQueue(int size) {
        result = new LinkedList<Person>();
        for (int i = 0; i < size; i++)
            result.add(PerGenerator.getObj().next());
        return result;
    }
}
class Test extends Person{
    private final int id = 4;
    public void f() {
        Integer[] arr;
    }
}

class Test2 {
    public static int t;
    Test2() {print("hello");}
    static {
        t = 4;
        print(t);
    }
}



public class Main {
    public static void main(String[] args) {
        //ContainerComparison.main(args);//сравнение контейнеров и массивов

        //ArrayOptions.main(args);//массивы объектов

        //print(QueuePerson.createQueue(5));

        //IceCream.main(args);//возврат массива

        //MultidimensionalPrimitiveArray.main(args);//агрегатная инициализация 2-ого массива

        //ThreeDWithNew.main(args);//инициализация через new 3-ого массива

        //RaggedArray.main(args);//ступенчатый массив(Векторы имеют разную длину)


        /*Integer[] a = new Integer[]{1, 2, 3};
        String[] s = new String[]{"lol", "kek"};
        Parameter b = new Parameter();//параметризованный класс, содеожащий метод, для возврата массива
        print(Arrays.toString(b.f(a)));
        print(Arrays.toString(b.f(s)));
        print(Arrays.toString(ParametirizedArrayType.f(a)));//параметризованный метод для возврата массива
        */

        //ArrayOfGenerics.main(args);//возможность создания массива параметризованных типов

        //print(new CountingGenerator().next());

        //CountingGeneratotTest.main(args);//тест счетного и рандомного генератора

        //CreateArraysTest.main(args);//(не доделал)тест массивов счетного и рандомного генератора

        CopyingArgs.main(args);
    }
}
