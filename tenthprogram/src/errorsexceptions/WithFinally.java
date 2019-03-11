package errorsexceptions;
import static errorsexceptions.util.Print.*;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;
//пример с finally
public class WithFinally {
    private static Switch sw = new Switch();
    public static void main() {
        try {
            sw.on();
            OnOffSwitch.f();//код, способный возбуждать исключения
        }catch (OnOffExceptions1 e) {
            print("OnOffExceptions1");
        }catch (OnOffExceptions2 e) {
            print("OnOffExceptions2");
        }finally {
            sw.off();
        }
    }
}
