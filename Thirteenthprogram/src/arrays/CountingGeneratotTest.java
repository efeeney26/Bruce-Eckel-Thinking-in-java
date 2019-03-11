package arrays;
import static arrays.util.Print.*;
//рефлексия с идиомой вложенных генераторов

public class CountingGeneratotTest {
    public static int size = 10;
    private static Class[]arr = new Class[1];
    public static void test(Class<?> surroundingClass) {
        arr[0] = surroundingClass;
        for (Class<?> type: arr) {
            printnb(type.getSimpleName() + ": ");
            try {
                Generator<?> g = (Generator<?>)type.newInstance();
                for (int i = 0; i < size; i++) {
                    printnb(g.next() + ", ");
                }
            }catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        test(CountingGenerator.class);
        print();
        test(RandomGenerator.class);
    }
}
