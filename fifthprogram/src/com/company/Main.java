package com.company;
import com.company.simple.*;


import static com.company.util.Print.*;

class Sundae {
    private Sundae () {};
    static Sundae makeSundae() { // Здесь установлен запрет на создание объекта через конструктор, надо вызывать метод makeSundae
        return new Sundae();
    }
}

class Sundae1 {
    private Sundae1() {};
    private static Sundae1 sd1 = new Sundae1(); // конструктор запрещен
    public static Sundae1 access() { //при вызове метода возвращается ссылка на обект класса Sundae1
        return  sd1;
    }
    void f() {print("sd1 was created");}
}

class WaterSource {
    private String s;
    WaterSource() {
        print("WaterSource()");
        s = "done";
    }
    public String toString() {
        return s;
    }
}

class SprinlerSystem {
    private String value1, value2, value3, value4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;
    public String toString() {
        return "value1 = " + value1 + " " +
                "value2 = " + value2 + " " +
                "value3 = " + value3 + " " +
                "value4 = " + value4 + " " +
                "i = " + i + " " + "f = " + f + " " +
                "source = " + source; //объект source преобразуется компилятор в троку через стандартный метод toString() у любого объекта он есть(не путай с объявленным мной методом toString())
    }
}

class Art {
    Art() {print("constructor Art");}
}

class Drawing extends Art{
    Drawing() {print("constructor Drawing");}
}

class Cartoon extends Drawing{
    Cartoon() {print("constructor Cartoon");}
}

class Game {
    Game(int i) {
        print("constr Game");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        print("constr BoardGame");
    }
}

class Chess extends BoardGame {//наследование
    Chess() {
        super(11); //(если у класса нет конструктора по умолчанию)чтобы вызвать конструктор базового класса, надо явно вызвать его через super с указанием аргументов
        print("constr Chess");
    }
}

class SpaceshipControl {
    void forward(int velocity) {};
}

class SpaceshipDelegation { //делегирование
    private String name;
    private SpaceshipControl controls = new SpaceshipControl();
    public SpaceshipDelegation(String name) {this.name = name;}
    public void forward(int velocity) {controls.forward(velocity);}
}

class Homer {
    char doh(char c) {
        print("doh(char)");
        return 'd';
    }
    float doh(float f) {
        print("doh(float)");
        return 1.0f;
    }
}
class Milhouse {
    /*@Override void doh(Milhouse m) { // если будет перегрузка запись через @Override дропнет ошибку, если будет переопрделение, то метод сработает(перегрузка - переопределение метода с другим типом аргуметов или с другим типом возвращаемого значения или смены мест аргументов), то
        print("doh(Milhouse)");}*/
}
class Bart extends Homer {
    void doh(Milhouse m) {
        print("doh(Milhouse)");
    }
}

public class Main {
    static private int a = 3;
    static void showA() {
        print(a);
    }
    public static void main(String[] args) {
        /*Vector v = new Vector();
        List l = new List();
        java.util.Vector v1 = new java.util.Vector();//полный путь для предотвращения конфликта имен*/

        /*print("Now its works");
        print(100);
        print(100L);
        print(3.14159);
        showA();//доступ к private предоставляется только для методов класса

        /*Sundae x = new Sundae();//не сработает, констркутор private
        Sundae x = Sundae.makeSundae();//рабтает.Вызов метода makeSundae()
        Sundae1.access().f();*/

        /*SprinlerSystem sprinklers = new SprinlerSystem();
        print(sprinklers.toString());//можно не указывать toString(), т.к. компилятор найдте метод в классе toString()
        //print(sprinklers.source);//done, не указываy toString(), т.к. компилятор найдте метод в классе toString()*/

        /*Detergent.main(args);
        Cleanser.main(args);*/

        //Cartoon x = new Cartoon();//наследование

        //Chess x = new Chess();//наследование с констрктором класса с аргументами

        /*SpaceshipDelegation protector = new SpaceshipDelegation("NSEA protector");
        protector.forward(100); //делегирование, метод объекта класса SpaceControls обернут в метод объекта protector класса SpaceDelegation*/

        /*CADSystem x = new CADSystem(47);
        try {
            //код и обработка исключений
        }finally {
            x.dispose();
        }*/

        /*Bart b = new Bart();
        b.doh('c');
        b.doh(1);
        b.doh(new Milhouse());*/

        /*Car car = new Car();
        car.left.window.roolup();
        car.wheel[1].inflate(47);*/

        /*Orc orc = new Orc("Лимбургер", 12);
        print(orc);
        orc.change("Боб", 19);
        print(orc);*/

        //new Wind().main(args);

        //BlankFinal.main(args);//константы final необходимо инициализировать

        Beetle.main(args);
    }
}
