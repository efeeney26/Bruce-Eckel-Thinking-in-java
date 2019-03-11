package generics;
import java.util.*;
import static generics.util.Print.*;
//прототип Arrays.asList()(та же функциональность)
public class GenericVarargs {
    public static <T> List<T> makeList(T ...args) {
        List<T> result = new ArrayList<T>();
        for (T item : args)
            result.add(item);
        return result;
    }
    public static void main() {
        List<String> list = makeList("lol", "kek", "cheburek");
        print(list);

    }
}
