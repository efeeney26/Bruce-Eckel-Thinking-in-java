package com.company;

import java.awt.*;
import java.util.Random;

class Tank {
	int level;
}

class Letter {
	char c;
}

class Value {
	int i;
}

public class Main {
	static void f(Letter y) {
		y.c = 5;
	}
	static int i;
	static float x;
	static boolean test1 (int value1) {
		System.out.println("Test1 " + (value1 < 1));
		return value1 < 1;
	}
	static boolean test2 (int value2) {
		System.out.println("Test2 " + (value2 < 2));
		return value2 < 2;
	}
	static boolean test3 (int value3) {
		System.out.println("Test3 " + (value3 < 3));
		return value3 < 3;
	}
    public static void main(String[] args) {

    	/*String str1 = "java";
		str1 += " is cool";*/

		//при копировании одной ссылки на объект в другую, обе ссылки начинают манипулировать с одним и тем же объектом
		/*System.out.println(str1);
		Tank tank1 = new Tank();
		Tank tank2 = new Tank();
		tank1.level = 9;
		tank2.level = 17;
		System.out.println(tank1.level);
		tank1 = tank2;
		System.out.println(tank1.level);*/

		//в этом случае статическая функция изменяет значение свойства объекта извне этого объекта
		/*Letter x = new Letter();
		x.c = 'a';
		System.out.println(x.c);
		f(x);
		System.out.println(x.c);*/

		//Рандомизатор
		/*Random rand = new Random();
		i = rand.nextInt(100) + 1;
		System.out.println(i);
		x = rand.nextFloat();
		System.out.println(x);*/

		//при сравнении примимтивов в объектой обертке создаются ссылки и оператор == и != сравнивает именно ссылки, а не примитивы(в последнем примере надо переопределять метод equals)
		/*Integer a = new Integer(4);
		Integer b = new Integer(4);
		int c = 4;
		int d = 4;
		System.out.println(c == d);
		System.out.println(a == b);
		System.out.println(a.equals(b));
		Value e = new Value();
		Value f = new Value();
		e.i = f.i = 4;
		System.out.println(e == f);
		System.out.println(e.equals(f));*/

		//Ускоренное вычисление(не выполнил 3-ий тест, т.к. 2-ой выдал false, а амперсанды запинаются на лжи)
		/*boolean result = test1(0) && test2(2) && test3(3);
		System.out.println("Result is " + result);*/

		//Явное приведение типов
		/*int i = 200;
		long j = 100;
		i = (int)j;
		System.out.println(i);
		float k = 0.7f;
		System.out.println((int)k); //0 - при приведении усекается целая часть
		System.out.println(Math.round(k)); //1*/
	}
}
