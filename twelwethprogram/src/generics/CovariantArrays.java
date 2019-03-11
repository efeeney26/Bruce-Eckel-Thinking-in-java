package generics;
import static generics.util.Print.*;
//массив производного типа можно присвоить ссылке на массив базового типа
class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}


public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();
        //тип времеи выполнения - Apple[], а не Fruit[] или Orange[]
        try {
            //Компилятор позволяет добавлять объекты Fruit
            fruits[0] = new Fruit();//ArrayStoreException
        }catch (Exception e) {
            print(e);
        }
        try {
            //Компилятор позволяет добавлять объекты  Orange
            fruits[0] = new Orange();//ArrayStoreException
        }catch (Exception e) {
            print(e);
        }
    }
}
