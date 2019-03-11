package collectionobj;
import java.util.*;
import static collectionobj.util.Print.*;
//вывод всех переменных окружения
public class EnvironmentVariables {
    public static void main() {
        for (Map.Entry entry: System.getenv().entrySet())
            print(entry.getKey() + ":" + entry.getValue());
        String[] arr = {"A", "B", "C"};
    }
}
