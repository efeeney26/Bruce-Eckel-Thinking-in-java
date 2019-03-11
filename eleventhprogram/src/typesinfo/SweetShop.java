package typesinfo;
import static typesinfo.util.Print.*;
//проверка процесса загрузки классов
class Candy {
    static {print("Загрузка класса Candy");}
}

class Gum {
    static {print("Загрузка класса Gum");}
}

class Cookie {
    static {print("Загрузка класса Cookie");}
}

public class SweetShop {
    public static void main() {
        print("в методе main");
        new Candy();
        print("послее создания объекта Candy");
        try {
            Class.forName("typesinfo.Gum");//для получения ссылки указывается путь с пакетом
        }catch (ClassNotFoundException e) {
            print("Класс Gum не найден");
        }
        print("после вызова метода Class.forName(\"Gum\")");
        new Cookie();
        print("после создания объекта Cookie");
    }
}
