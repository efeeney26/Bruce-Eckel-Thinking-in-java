package errorsexceptions;
import static errorsexceptions.util.Print.*;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;
//за каждым освобождаемым объектом следует try-finally

class NeedsCleanup {//конструирование не может завершиться неудачно
    private static long counter = 1;
    private final long id = counter++;
    public void dispose() {print("NeedsCleanup " + id + " завершен");}
}

class ConstructionException extends Exception {}

class NeedsCleanup2 extends NeedsCleanup {
    //возможны сбои при конструировании
    public NeedsCleanup2() throws ConstructionException {}
}

public class CleanupIdiom {
    public static void main() {
        //Секция 1
        NeedsCleanup nc1 = new NeedsCleanup();
        try {
            //..
        }finally {
            nc1.dispose();
        }
        //Секция 2
        //если сбои при конструировании исключены,
        //объекты можно группировать
        NeedsCleanup nc2 = new NeedsCleanup();
        NeedsCleanup nc3 = new NeedsCleanup();
        try {
            //..
        }finally {
            nc3.dispose();
            nc2.dispose();
        }
        //Секция 3
        //если при конструировании возможны сбои, каждый объект
        //защищается отдельно
        try {
            NeedsCleanup2 nc4 = new NeedsCleanup2();
            try {
                NeedsCleanup2 nc5 = new NeedsCleanup2();
                try {
                    //..
                }finally {
                    nc5.dispose();
                }
            }catch (ConstructionException e) {//конструктор nc5
                print(e);
            }finally {
                nc4.dispose();
            }
        }catch (ConstructionException e) {//конструктор nc4
            print(e);
        }
    }
}
