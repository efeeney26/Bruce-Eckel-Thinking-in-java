package innerclasses;
import static innerclasses.util.Print.*;
//Вложенные статические внутренние классы

public class Parcel10 {
    private static class PContents implements Contents {
        private PContents(int i) {this.i = i;}
        private int i;
        public int value() {return i;}
    }
    protected static class PDestination implements Destination {//вложенный класс
        private String label;
        private PDestination(String label) {this.label = label;}
        public String readLabel() {return label;}
        //вложенные классы могут содержать другие статические переменные
        public static void f(){}
        static int x = 10;
        static class AnotherLevel {
            public static void f() {}
            static int x = 10;
        }
    }
    public static Contents contents(int i) {
        return new PContents(i);
    }
    public static Destination destination(String s) {
        return new PDestination(s);
    }
    public static void main(String[] args) {
        Contents c = contents(5);
        Destination d = destination("Тасмания");
        print(c.value());
        print(d.readLabel());
    }
}
