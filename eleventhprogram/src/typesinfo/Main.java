package typesinfo;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static typesinfo.util.Print.*;

abstract class Ball {
    private int size;
    Ball(int size) {this.size = size;}
    abstract void fly();
    abstract void jump();
    public int getSize() {return size;}
}

class BallFactory {
    public static Ball createBall(int size) {
        if( size < 5)
            return new FootballBall(size);
        else
            return new BascketballBall(size);
    }
}

class FootballBall extends Ball {
    public FootballBall(int size) { super(size);}
    public void fly() {}
    public void jump() {}
    public String toString() {return "make FootballBall";}
}

class BascketballBall extends Ball{
    public BascketballBall(int size) {super(size);}
    public void fly() {}
    public void jump() {}
    public String toString() {return "make BascketballBall";}
}

class Test1 {}
class Test2 extends Test1 {}

public class Main {
    public static void main(String[] args) throws Exception {
	    //Shapes.main();//работа полиморфизм

        //SweetShop.main();//проверка процесса загрузки классов

        //ToyTest.main();//Тестирование класса Class

        //ClassInitialization.main();//инициализация классов

        //RegistredFactories.main();//регистрация фабрик в базовом классе

        //ShowMethods.main(args);//Использование рефлексии для вывода полного списка методов класса, в том числе и определенных в базовом классе

        //SimpleProxyDemo.main();//Динамические посредники, использование паттерна proxy(посредник)

        Test1 t = new Test2();
        print(t.getClass().getSimpleName()
        );
    }
}
