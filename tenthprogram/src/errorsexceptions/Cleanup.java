package errorsexceptions;
import static errorsexceptions.util.Print.*;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;
//Гарантированное освобождение ресурсов
public class Cleanup {
    public static void main() {
        try {
            InputFile in = new InputFile("Cleanup Java");
            try {
                String s;
                int i = 1;
                while ((s = in.getLine())!= null);
                //построчная обработка
            }catch (Exception e) {
                print("Перехвачено Exception в main");
                e.printStackTrace(System.out);
            }finally {
                in.dispose();
            }
        }catch (Exception e) {
            print("Сбой при конструировании InputFile");
        }
    }
}

