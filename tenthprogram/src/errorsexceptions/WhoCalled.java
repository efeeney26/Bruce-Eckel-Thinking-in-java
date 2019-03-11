package errorsexceptions;
import static errorsexceptions.util.Print.*;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;

//Программный доступ к данным трассировки стека

public class WhoCalled {
    static void f() {
        //Выдача исключений для заполнения трассировочных данных
        try {
            throw new Exception();
        }catch (Exception e) {
            for (StackTraceElement ste: e.getStackTrace()) {
                print(ste.getMethodName());
            }
        }
    }
    static void g() {f();}
    static void h() {g();}
    public static void main() {
        f();
        print("----------------");
        g();
        print("----------------");
        h();
    }
}
