package generics;
import java.util.*;

import static generics.util.Print.*;

interface Base {
    void f();
}

class Test implements Base {
    public void f() {print(1);};
    Test() {}
    class Test2 extends Test {
        public void f() {print(2);}
        void g() {}
        Test2() {}
        void getTest2F() {this.f();}
    }
}

class Fibonacci {

    private int fib(int n) {
        return n < 2 ? n : fib(n - 2) + fib((n - 1));
    }
    void start(int size) {
        for (int i = 0; i < size; i++) {
            printnb(fib(i) + " ");
        }
    }
}

enum WaterColors {
    RED, GREEN, BLUE, WHITE, GREY, PURPLE, ORANGE
}

public class Main {
    public static void main(String[] args) {
        //Holder2.main();//хранение объекта в классе Object

        //print(new TwoTuple<>(3, "ok").toString());//концепция кортеж из 2 объектов

        //TestTuples.main();//тестирование кортежей

        //LinkedStack.main();//стек реализовынный на базе внутренней структуры

        //RandomList.main();//контейнер со случайным выбором элемента

       /* Test t = new Test();
        Test t2 = t.new Test2();
        ((Test.Test2) t2).getTest2F();*/

        //CoffeeGenerator.main();

        /*new Fibonacci().start(10);*/

        //GenericMethods.main();//парамтризованные методы

        //GenericVarargs.main();//прототип Arrays.asList()(та же функциональность)

        //Generators.main(args);//обобщенный метод заполнения коллекции

        //BasicGeneratorDemo.main(args);//Генератор для CountedObject

        /*Set<String> set1 = new HashSet<String>(Arrays.asList("blue", "red", "green"));
        Set<String> set2 = new HashSet<String>(Arrays.asList("yellow", "red", "grey"));
        Set set3 = Sets.union(set1, set2);
        Set set4 = Sets.intersection(set1, set2);
        //print(set3);//собирает все в один Set(без повторений) в set3
        //print(set4);//в set4 оставляет только одинаковые поля set3 и set4
        Set set5 = Sets.difference(set3, set4);//в set5 оставляет только уникальные поля set1 и set2 в одном set
        //print(set5);*/

        /*Set<WaterColors> set1 = EnumSet.range(WaterColors.GREEN, WaterColors.WHITE);
        print(set1);//[GREEN, BLUE, WHITE] */

        //BankTeller.main(args);//простая имитация банковского обслуживания

        //TupleList.main(args);//построение сложных параметризованных типов путем объединения

        /*Class intL = new ArrayList<Integer>().getClass();
        Class strL = new ArrayList<String>().getClass();
        print(intL == strL);//проблема стирания в java*/

        //CovariantArrays.main(args);//массив производного типа можно присвоить ссылке на массив базового типа

        //GenericWriting.f1();//параметризация контейнеров
    }
}
