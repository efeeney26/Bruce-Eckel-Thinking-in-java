package errorsexceptions;
import static errorsexceptions.util.Print.*;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;
//Расширение классов исключений

class MyException2 extends Exception {
    private int x;
    public MyException2() {}
    public MyException2(String msg) {super(msg);}
    public MyException2(String msg, int x) {
        super(msg);
        this.x = x;
    }
    public int val() {return x;}
    public String getMessage() {
        return "Подробное сообщение " + x + super.getMessage();
    }
}

public class ExtraFeatures {
    public static void f() throws MyException2 {
        print("Возбуждено в f()");
        throw new MyException2();
    }
    public static void g() throws MyException2 {
        print("Возбуждено в g()");
        throw new MyException2("MyException в g()");
    }
    public static void h() throws MyException2 {
        print("Возбуждено в h()");
        throw new MyException2("MyException в h()", 47);
    }
    public static void main() {
        try {
            f();
        }catch (MyException2 e) {
            e.printStackTrace(System.out);
        }
        try {
            g();
        }catch (MyException2 e) {
            e.printStackTrace(System.out);
        }
        try {
            h();
        }catch (MyException2 e) {
            e.printStackTrace(System.out);
            print("e.val() = " + e.val());
        }
    }
}
