package errorsexceptions;
import static errorsexceptions.util.Print.*;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;
//пример, где необходим блок finally(но его тут нет)(используется, когда в исходное состояние надо вернуть что-то другое, а не память) - ниже пример с переключателем

class Test {
    public  void printObj() {print(this);}
    public String toString() {return "obj";}
}

class Switch {
    private boolean state = false;
    public boolean read() {return state;}
    public void on() {state = true; print(this);}
    public void off() {state = false; print(this);}
    public String toString() {return state?"on":"off";}
}

class OnOffExceptions1 extends Exception {}
class OnOffExceptions2 extends Exception {}

public class OnOffSwitch {
    private static Switch sw = new Switch();
    static void f() throws OnOffExceptions1, OnOffExceptions2 {}
    public static void main() {
        try {
            sw.on();
            f();//код способный возбуждать исключения
            sw.off();
        }catch (OnOffExceptions1 e) {
            print("OnOffExceptions1");
            sw.off();
        }catch (OnOffExceptions2 e) {
            print("OnOffExceptions2");
            sw.off();
        }
    }
}
