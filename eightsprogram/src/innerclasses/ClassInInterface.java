package innerclasses;
import static innerclasses.util.Print.*;
//класс внутри интерфейса
public interface ClassInInterface {
    void howdy();
    class Test implements ClassInInterface {
        public void howdy() {
            print("Привет!");
        }
        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
