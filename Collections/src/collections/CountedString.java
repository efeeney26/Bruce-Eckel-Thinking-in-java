package collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static collections.util.Print.*;
//напсиание хорошей реализации hashCode()
public class CountedString {
    private static List<String> created = new ArrayList<String>();
    private String s;
    private int id = 0;
    public CountedString(String str) {
        s = str;
        created.add(s);
        //id - общее количество экземпляров данной строки, используемых классом CountedString
        for (String s2 : created) {
            if(s2.equals(s))
                id++;
        }
    }
    public String toString() {
        return "String: " + s + ", id: " + id + ", hashCode(): " + hashCode();
    }
    public int hashCode() {
        //очень простая схема - вернуть s.hashCode() * id
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        return result;
    }
    public boolean equals(Object o) {
        return o instanceof CountedString && s.equals(((CountedString)o).s) && id == ((CountedString)o).id;
    }
    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<CountedString, Integer>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");
            map.put(cs[i], i);//упакрвка int в Integer
        }
        print(map);
        for ( CountedString cstring : cs ) {
            print("Looking up String: " + cstring);
            print(map.get(cstring));
        }
    }
}
