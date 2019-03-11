package errorsexceptions;
import static errorsexceptions.util.Print.*;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;
//подавление контролируемых исключений

class WrapCheckedException {
    void throwRuntimeException(int type) {
        try {
            switch (type) {
                case 0: throw new FileNotFoundException();
                case 1: throw new IOException();
                case 2: throw new RuntimeException("Где я?");
                default: return;
            }
        }catch (Exception e) {
            //превращаем в неконтролируемое
            throw new RuntimeException(e);
        }
    }
}

class SomeOtherException extends Exception {}

public class TurnOffChecking {
    public static void main() {
        WrapCheckedException wce = new WrapCheckedException();
        //можно вызвать throw new RuntimeException() без блока try
        //и позволить исключению RuntimeException покинуть метод
        wce.throwRuntimeException(3);
        //или перехватить исключение
        for (int i = 0; i < 4; i++) {
            try {
                if (i < 3)
                    wce.throwRuntimeException(i);
                else
                    throw new SomeOtherException();
            }catch (SomeOtherException e) {
                print("SomeOtherException " + e);
            }catch (RuntimeException re) {
                try {
                    throw re.getCause();
                }catch (FileNotFoundException e) {
                    print("FileNotFoundException " + e);
                }catch (IOException e) {
                    print("IOException " + e);
                }catch (Throwable e) {
                    print("Throwable " + e);
                }
            }
        }
    }
}
