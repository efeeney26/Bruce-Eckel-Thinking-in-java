package innerclasses;
import static innerclasses.util.Print.*;
//Безымянные внутренние классы

public class Parcel6 {
    public Contents contents() {
        return new Contents() {
            private int i = 1;
            public int value() {return i;}
        };
    }
    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        Contents c = p.contents();
        print(c.value());
    }
}

/*
public class Parcel6 {                          - удлиненная запись записи выше
    class PContents implements Contents {
        private int i = 1;
        public int value() {return i;}
    }

    public Contents contents() {
        return new PContents();
    }

    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        Contents c = p.contents();
        print(c.value());
    }
}*/
