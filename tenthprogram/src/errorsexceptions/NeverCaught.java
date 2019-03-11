package errorsexceptions;
import static errorsexceptions.util.Print.*;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;
//игнорирование RuntimeException

public class NeverCaught {

    static void f() {
        throw new NullPointerException("из f()");
    }
    static void g() {
        f();
    }
    public static void main() {
        g();
    }
}
