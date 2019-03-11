package com.company;
import static com.company.util.Print.*;
//Сначала происходит инициализация переменных(сначала static, потом не static), потом запускается тело конструктора с неявным указанием на запуск конструктор базового типа, затем выполняется остаток тела конструктора производного типа
class Inspect {
    private int i = 9;//(3)
    protected int j;//(4) j = 0
    Inspect() {
        print("i = " + i + ",j = " + j);//(9) напечаталось, что j = 0
        j = 39;//(10) здесь j инициализировалась
    }
    private static int x1 = printInit("Поле static Inspect x1 инициализировано");//(1) перед инициализацией x1 = 0
    static int printInit(String s) { //(2) x1 = 47 b печаетаеся строка s
        print(s);
        return 47;
    }
}

public class Beetle extends Inspect {
    private int k = printInit("Поле Beetle k инициализировано");//(11)k = 47, печатается строка
    public Beetle() {
        super();//можно не указывать явно, т.к. конструктор базового типа все равно запускается(8)
        print("k = " + k);//(12)печать k
        print("j = " + j);//(13)печать j
    }
    private static int x2 = printInit("Поле static Inspect x2 инициализировано");//(5) x2 = 47, печатается строка x2
    public static void main(String[] args) {
        print("Конструктор Beetle");//(6)т.к. main - static, то инициализируется по порядку объявления
        Beetle b = new Beetle();//(7)запускается конструктор Beetle
    }
}
