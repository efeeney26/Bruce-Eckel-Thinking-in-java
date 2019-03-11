package errorsexceptions;
import static errorsexceptions.util.Print.*;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;
//блок finally выполняется всегда

class ThreeException extends Exception {}

public class FinallyWorks {
    static int count = 0;
    public static void main() {
        while (true) {
            try {
                if (count++ == 0)
                    throw new ThreeException();
                print("Нет исключения");
            }catch (ThreeException e) {
                print("ThreeException");
            }finally {
                print("в блоке finally");
                if(count == 2) break;//вне цикла while
            }
        }
    }
}
