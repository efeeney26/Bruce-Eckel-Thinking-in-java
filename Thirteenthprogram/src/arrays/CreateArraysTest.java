package arrays;
import static arrays.util.Print.*;
import java.util.Collection;

//тест массивов, заполненых с помощью генераторов
public class CreateArraysTest {
    private static Class[] arr = new Class[1];
    private static Class[] array;
    public static void test(Class<?> surroundingClass, int size) {
        array = new Class[size];
        arr[0] = surroundingClass;
        for (Class<?> type : arr) {
            printnb(type.getSimpleName() + ": ");
        }
    }
    public static void main (String[]args){

    }

}
