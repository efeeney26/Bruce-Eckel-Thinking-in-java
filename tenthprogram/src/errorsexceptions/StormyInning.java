package errorsexceptions;
import static errorsexceptions.util.Print.*;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;
//переопределенные методы могут возбуждать только исключения,
//описанные в версии базового класса, или исключения,
//унаследованные от исключений базового класса

class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}

abstract class Inning {
    public Inning() throws BaseballException {}
    public void event() throws BaseballException {}//реальное исключение не возбуждается
    public abstract void atBat() throws Strike, Foul;
    public void walk() {}//не возбуждает исключений
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
    public void event() throws RainedOut;
    public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {
    //можно добавлять новые исключения для конструкторов
    //но нужно учитывать и исключения базвого конструктора
    public StormyInning() throws RainedOut, BaseballException {}
    public StormyInning(String s) throws Foul, BaseballException {}

    //обычные методы должны соответствовать базовым
    //void walk() throws PopFoul {}//не рабочий метод, этот метод в базовом классе не возбуждает PopFoul

    //Интерфейс НЕ МОЖЕТ добавлять исключения к
    //существующим методам базового класса
    //public void event() throws RainedOut {}//метод базового класса перекрывает метод интерфейса

    //если метод не был определен в базовом классе, исключения допускаются
    public void rainHard() throws RainedOut {}//в базовом классе нет метода rainHard, допускается

    //метод может не возбуждать исключений вообще
    //даже если базовая версия делает это
    public void event() {}

    //переопределенные методы могут возбуждать
    //унаследованные исключения
    public void atBat() throws PopFoul {}
    public static void main() {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        }catch (PopFoul e) {
            print("Pop foul");
        }catch (RainedOut e) {
            print("Rained out");
        }catch (BaseballException e) {
            print("Обобхенное исклчение");
        }
        //Strike не возбуждается в производной версии
        try {
            Inning i = new StormyInning();
            i.atBat();//при восходящем преобразовании необходим перехватывать исключения из базовой версии метода
        }catch (Strike e) {
            print("Strike");
        }catch (Foul e) {
            print("Strike");
        }catch (RainedOut e) {
            print("Rained out");
        }catch (BaseballException e) {
            print("Обобхенное исклчение");
        }
    }
}
