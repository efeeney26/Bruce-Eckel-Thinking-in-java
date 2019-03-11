package innerclasses;
import static innerclasses.util.Print.*;
//сравнение процесса создания локального внутреннего класса и безымянного

interface Counter {
    int next();
}

public class LocalInnerClass {
    private int count = 0;
    Counter getCounter(final String name) {
        //Локальный внутренний класс
        class LocalCounter implements Counter{
            public LocalCounter (){
                //у локального класса может быть свой конструктор
                print("LocalCounter()");
            }
            public int next() {
                printnb(name);
                return count++;
            }
        }
        return new LocalCounter();
    }
    Counter getCounter2(final String name) {
        //безымянный
        return new Counter() {
            //у безымянного конструктора не может быть
            //именованного конструктора, "легальна" только
            //инициализация экземпляром
            {
                print("Counter()");
            }
            public int next() {
                printnb(name);
                return count++;
            }
        };
    }
    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter
                c1 = lic.getCounter("Локальный"),
                c2 = lic.getCounter2("Безымянный");
        for (int i = 0; i < 5; i++)
            print(c1.next());
        for (int i = 0; i < 5; i++)
            print(c2.next());
    }
}
