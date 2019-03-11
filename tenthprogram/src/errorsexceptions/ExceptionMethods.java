package errorsexceptions;
import static errorsexceptions.util.Print.*;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;
//Демонстрация методов класса Exception
public class ExceptionMethods {
    public static void main() {
        try {
            throw new Exception("Мое исключение");
        }catch (Exception e) {
            print("Перехвачено");
            print("getMessage() " + e.getMessage());
            print("getLocalizeMessage " + e.getLocalizedMessage());
            print("toString()" + e);
            printnb("printStackTrace(): ");
            e.printStackTrace(System.out);
        }
    }
}
