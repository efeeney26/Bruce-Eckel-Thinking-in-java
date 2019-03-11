package enumtypes;
import static enumtypes.util.Print.*;
//возможности класса enum
enum Shrubbery {GROUND, CRAWLING, HANGING}

public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery shrubbery : Shrubbery.values()/*создает массив констант перечисления*/) {
            print(shrubbery + " ordinal " + shrubbery.ordinal());
            printnb(shrubbery.compareTo(Shrubbery.CRAWLING) + " ");
            printnb(shrubbery.equals(Shrubbery.CRAWLING) + " ");
            print(shrubbery == Shrubbery.CRAWLING);
            print(shrubbery.getDeclaringClass());
            print(shrubbery.name());
            print("-------------------------------------");
            //Получить значения из перечисления по строковому имени
        }
        for ( String s : "HANGING CRAWLING GROUND".split(" ") ) {
                Shrubbery shrubbery1 = Enum.valueOf(Shrubbery.class, s);
                print(shrubbery1);
        }
        for (int i = 0; i < 3; i++) {
            print(Enum.valueOf(Shrubbery.class, "HANGING"));
        }
    }
}
