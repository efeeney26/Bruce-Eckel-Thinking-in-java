package com.company;

import java.util.Arrays;
import java.util.Random;

class Rock {
    Rock (int i) {
        System.out.print("Rock" + i + ",");
    }
}

class Tree {
    int height;
    Tree () {
        System.out.println("plant a tree");
    }
    Tree(int initialHeight) {
        height = initialHeight;
        System.out.println("plant a tree with height: " + initialHeight);
    }
    void info() {
        System.out.println("Tree has height: " + height);
    }
    void info(String str) {
        System.out.println(str + " tree has a height: " + height);
    }
}

/*class Leaf {
    int i;
    Leaf increment () {
        i++;
        return this;
    }
    void print () {
        System.out.println("i = " + i);
    }
}*/

/*class Person {
    public void eat(Apple apple) {
        Apple peeled = apple.getPeeled();
        System.out.println("Yummi");
    }
}

class Peeler {
    static Apple peel(Apple apple) {
        return apple;
    }
}

class Apple {
    Apple getPeeled() {
        return Peeler.peel(this);
    }
}*/

class Flower {
    int petalCount = 0;
    String s = "initial value";
    Flower(int petals) {
        petalCount = petals;
        System.out.println("Constructor with args int, petalCount = " + petalCount);
    }

    Flower(String ss) {
        System.out.println("Constructor with args int, petalCount = " + ss);
        s = ss;
    }

    Flower(String s, int petals) {
        this(petals);
        //this(s) //Вызов второго конструктора через this, если один был вызван заранее(this(petals)) запрещен. Вызов другого конструктора должен быть 1-ой строкой, иначе будет ошибка
        this.s = s; // Другое использование this не в контексте конструктора, а в контексте объекта(сделано тоьлко потому, что имя поля и аргумента совпадают, если имена не совпадают THIS НЕ ПИШЕМ!!
        System.out.println("Args String and int");
    }

    Flower() {
        this("hi", 47 );
        System.out.println("Constructor default(without args)");
    }

    void printPetalCount() {
        //this(11)//Разрешается вызывать другой конструктор только из конструтора
        System.out.println("petalCount = " + petalCount + " s = " + s);
    }
}

class Book {
    boolean checkedOut = false;
    Book(boolean checkOut) {
        checkedOut = checkOut;
    }
    void checkIn() {
        checkedOut = false;
    }
    public void finalize() {
         if(checkedOut)
             System.out.println("Error checkOut");
    }
}

class Window {
    Window(int marker) {
        System.out.println("Window(" + marker + ")");
    }
}

class House {
    Window w1 = new Window(1); //(1)
    House() {
        System.out.println("House()"); //(4)
        Window w3 = new Window(33); //(5)
    }
    Window w2 = new Window(2); //(2)
    void f() {
        System.out.println("f()"); //(6)
    }
    Window w3 = new Window(3); //(3)
}

class  Cup {
    Cup(int marker) {
        System.out.println("Cup(" + marker +")");
    }
    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;
    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }
    Cups() {
        System.out.println("Cups()");
    }
}

class Mug {
    Mug(int marker) {
        System.out.println("Mug(" + marker +")"); //(1),(2)
    }
    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}

class Mugs {
    Mug mug1;
    Mug mug2;
    {
        mug1 = new Mug(1); //(1)
        mug2 = new Mug(2); //(2)
        System.out.println("Args were initialized"); //(3)
    }
    Mugs() {
        System.out.println("Migs()"); //(4)
    }
    Mugs(int i) {
        System.out.println("Mugs(int)");
    }
}

class A {int i;}

public class Main {
    //static Cups cups1 = new Cups();
    //static Cups cups2 = new Cups();

    static void printArray(Object args[]) {
        System.out.println(Arrays.toString(args));
    }

    static void newPrintArray(Object ...args) { //работает spread-оперетор, когда не знаешь, сколько будет аргументов и какого типа они будут, можно поставить тип Object, т.к. все наследуется от Object
        System.out.println(Arrays.toString(args));
    }

    public static void main(String[] args) {
        /*for (int i = 0; i < 5; i++) {
            new Rock(i);
        }*/

        /*for (int i = 0; i < 5; i++) {
            Tree t = new Tree(i);
            t.info();
            t.info("Overload method");
        }
        new Tree();*/

        /*Leaf inc = new Leaf();
        inc.increment().increment().increment().print();*/

        //new Person().eat(new Apple());

        /*Flower x = new Flower();
        x.printPetalCount();*/

        /*Book novel = new Book(true);
        novel.checkIn(); //правильная очистка
        new Book(true);//забыли про очистку
        System.gc();//рпинудительная сборка мусора(garbage collector) и финализация*/

        /*House h = new House();
        h.f();*/

        /*System.out.println("Inside main()");
        Cups.cup1.f(99);*/

        /*System.out.println("In main()");//(0)
        new Mugs();
        System.out.println("new.Mugs() was done");//(5)
        new Mugs(1);
        System.out.println("new Mugs(1) was  done");*/

        /*int arr1[] = {1,2,3,4,5};
        int arr2[];
        arr2 = arr1;//копируем ссылку на массив arr1 в arr2, обе ссылки указывают на один и тот же массив
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr2[i] + 1;
        }
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("arr1[" + i + "] = "+  arr1[i]);
        }*/

        /*int arr[];
        Random rand = new Random(47);
        arr = new int[rand.nextInt(20)]; //размер массива генерится случайным числом от 0 до зн-я аргумента
        //int arr[] = new int[rand.nextInt(20)] // рекомендуется такая запись
        System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));*/

        /*Random rand = new Random(47);
        Integer arr[] = new Integer[rand.nextInt(20)]; // класс-обертка над притивом int, поэтому создаем массив не из притивов int, а из ссылок на объекты класса Integer
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++)
            arr[i] = rand.nextInt(500); //автоматическая упаковка
        System.out.println(Arrays.toString(arr));*/

        /*Integer arr1[] = { //определение массива 1
                new Integer(1),
                new Integer(2),
                3
        };
        Integer arr2[] = new Integer[]{ //определение массива 2
                new Integer(1),
                new Integer(2),
                3
        };
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));*/

        printArray(new Object[]{
                new Integer(47), new Float(3.14), new Double(11.11)
        });
        printArray(new Object[]{"one", "two", "three"});
        printArray(new Object[]{new A(), new A(), new A()});
        newPrintArray(new Object[]{1, "fool", true}); //работают и как коллекции(разные типы)
    }

}
