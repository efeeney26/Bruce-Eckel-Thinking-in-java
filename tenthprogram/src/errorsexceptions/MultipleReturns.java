package errorsexceptions;
import static errorsexceptions.util.Print.*;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;
//finally c return
public class MultipleReturns {
    public static void f(int i) {
        try {
            print("Инициализация, требующая завершения");
            print("Точка 1");
            if (i == 1) return;
            print("Точка 2");
            if (i == 2) return;
            print("Точка 3");
            if (i == 3) return;
            print("Конец");
            return;
        }finally {
            print("Завершение");
        }
    }
    public static void main() {
        for (int i = 1; i <= 4; i++) {
            f(i);
        }
    }
}
