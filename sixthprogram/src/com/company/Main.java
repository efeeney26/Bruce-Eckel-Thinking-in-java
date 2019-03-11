package com.company;
import static com.company.util.Print.*;

class PrivateOverride {
    private void f() {print("private f()");}
    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();//private f(). Случилось из-за того, что у PrivateOverride метод f() private производному классу Derived не достпен. Метод Public f() Derived является новым методом, поэтому вызвался метод базового класса. Переопределяются только не закрытые(private) методы, т.е. методам производного класса стоит присваивать имена, отличные от скрытх методов базового класса
    }
}

class Derived extends PrivateOverride {
    public void f() {print("public f()");}
}

class Test {
    int i;
    Test(int i) {
        this.i = i;
    }
}

class Test1 extends Test {
    int i;
    Test1(int i) {
        super(i);//если у базового класса нет конструктора по умолчанию, необходмо явно вызывать конструктор базового типа с аргументом
        this.i = i;
    }
}

class Useful {
    public void f() {}
    public void g() {}
}

class MoreUseful extends Useful {
    public void f() {}
    public void g() {}
    public void a() {}
    public void b() {}
    public void c() {}
    public void d() {}
}

public class Main {

    public static void main(String[] args) {
        //Shapes.main(args);

        //new PrivateOverride().main(args);

        //new Sandwich();

        /*Frog frog = new Frog();
       print("Пока!");
       frog.dispose();*/

        /*Shared shared = new Shared();
        Composing[] composing = {new Composing(shared),
                new Composing(shared), new Composing(shared),
                new Composing(shared), new Composing(shared)};
        for (Composing c: composing) {
                c.dispose();
        }*/

        //new PolyComnstructors().main(args);

        //new Transmogrify().main(args);

        Useful[] x = {
                new Useful(),
                new MoreUseful()
        };
        x[0].f();
        //x[1].a();//работать не будет
        ((MoreUseful)x[1]).a();//работает только с приведенем типов(Нисходящее преобразование)
        ((MoreUseful)x[0]).a();//происходит исключение
         }
}
