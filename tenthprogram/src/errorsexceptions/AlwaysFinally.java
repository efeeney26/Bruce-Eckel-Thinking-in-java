package errorsexceptions;
import static errorsexceptions.util.Print.*;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;
//Finally выполняется всегда

class FourExceptions extends Exception {}

public class AlwaysFinally {
    public static void main() {
        print("Входим в 1-ый блок try");
        try {
            print("Входим во 2-ой блок try");
            try {
                throw new FourExceptions();
            }finally {
                print("finally  во 2-ом блоке try");
            }
        }catch (FourExceptions e) {
            print("Перехвачено FourExceptions в 1-ом блоке try");
        }finally {
            print("finally в 1-м блоке try");
        }
    }
}
