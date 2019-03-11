package innerclasses;
import static innerclasses.util.Print.*;
//использование внутренних классов для создания обратных вызовов(callbacks)

interface Incrementable {
    void increment();
}

//Простая реализация интерфейса
class Callee1 implements Incrementable {
    private int i = 0;
    public void increment() {
        i++;
        print(i);
    }
}

class MyIncrement {
    public void increment() {print("Другая операция");}
    public static void f(MyIncrement myIncrement) {myIncrement.increment();}
}

//если класс должен вызвать метод increment() по-другому, необходимо использовать внутренний класс
class Callee2 extends MyIncrement {
    private int i = 0;
    public  void increment() {
        super.increment();
        i++;
        print(i);
    }
    private class Closure implements Incrementable {
        public void increment() {
            //указывается метод внешнего класса, в противном случае возикает бесконечная рекурсия
            Callee2.this.increment();//
        }
    }
    Incrementable getCallbackReference() {
        return new Closure();
    }
}

class Caller {
    private Incrementable callbackReference;
    Caller(Incrementable cbh) {callbackReference = cbh;}
    void go() {callbackReference.increment();}
}

public class Callbacks {
   public static void main(String[] args) {
       Callee1 callee1 = new Callee1();
       Callee2 callee2 = new Callee2();
       MyIncrement.f(callee2);//Другая операция; 1
       Caller caller1 = new Caller(callee1);
       Caller caller2 = new Caller(callee2.getCallbackReference());
       caller1.go();//1
       caller1.go();//2
       caller2.go();//Другая операция; 2
       caller2.go();//Другая операция; 3
   }
}
