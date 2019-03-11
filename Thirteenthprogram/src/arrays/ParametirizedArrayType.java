package arrays;
import static arrays.util.Print.*;
//параметризованный тип массива

class Parameter<T> {
    public T[] f(T[] arg) {return arg;}
}

public class ParametirizedArrayType {
    public static <T> T[] f(T[] arg) {return arg;}
}
