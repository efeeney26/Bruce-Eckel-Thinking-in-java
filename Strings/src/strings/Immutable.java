package strings;
import static strings.util.Print.*;

public class Immutable {
    public static String upCase(String s) {
        return s.toUpperCase();
    }
    public static void main(String[] args) {
        String s1 = "Hello";
        print(s1);
        String s2 = upCase(s1);//передается копия сылки на q, физическое местонахождение оъекта не изменяется(ссылки копируются при передаче)
        print(s2);
        print(s1);
    }
}
