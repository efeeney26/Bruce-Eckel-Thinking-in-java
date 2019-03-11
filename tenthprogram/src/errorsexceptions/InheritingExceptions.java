package errorsexceptions;
import static errorsexceptions.util.Print.*;
import java.util.*;
//Создание собственного исключения
class SimpleException extends Exception {}

public class InheritingExceptions {
    public void f() throws SimpleException {
        print("Возбуждаем SimpleException из f()");
        throw new SimpleException();//метод создает новое исключение типа SimpleException
    }
    public static void main() {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        }catch (SimpleException e) {//обработчик исключений для типа SimpleException
            print("Перехвачено!");
        }
    }
}
