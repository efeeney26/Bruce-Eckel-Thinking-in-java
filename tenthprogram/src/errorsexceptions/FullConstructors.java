package errorsexceptions;
import static errorsexceptions.util.Print.*;
import java.util.*;
//создание класса исключения с конструктором, получающим аргумент String
class MyException extends Exception {
    public MyException () {}
    public MyException(String msg) {super(msg);}
}

public class FullConstructors {
    public static void f() throws MyException {
        print("Возбуждаем MyException из f()");
        throw new MyException();
    }
    public static void g() throws MyException {
        print("Возбуждаем MyException из g()");
        throw new MyException("Создано в g()");
    }
    public static void main() {
        try {
            f();
        }catch (MyException e) {
            e.printStackTrace(System.err);
        }
        try {
            g();
        }catch (MyException e) {
            e.printStackTrace(System.err);
        }
    }
}
