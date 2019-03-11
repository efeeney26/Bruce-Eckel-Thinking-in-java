package collectionobj;
import java.util.*;
import static collectionobj.util.Print.*;
//использование Map для поиска некоторого ключа по его строкову описанию

public class NumbersMap {
    public static void main() {
        Map<String, Integer> numberMap = new HashMap<String, Integer>();
        numberMap.put("First number", 0);
        numberMap.put("Second number", 1);
        numberMap.put("Third number", 2);
        print(numberMap);
        Integer fn = numberMap.get("First number");
        print(fn);
        print(numberMap.containsKey("Second number"));
        print(numberMap.containsValue(2));
    }

}
