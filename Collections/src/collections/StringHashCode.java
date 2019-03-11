package collections;
import static collections.util.Print.*;
//у объектов String, содержащих одинаковые последовательности символов, все ссылки указывают на один и тот же участок памяти
public class StringHashCode {
    public static void main(String[] args) {
        String[] hellos = "Hello Hello".split(" ");
        print(hellos[0].hashCode());
        print(hellos[1].hashCode());
    }
}
