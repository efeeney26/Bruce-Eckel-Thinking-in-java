package innerclasses;
import static innerclasses.util.Print.*;
//более короткая версия программы Parcel4

public class Parcel8 {
    public Destination destination(String s) {
        return new Destination() {
            private String label = s;
            public String readLabel() {return label;}
        };
    }
    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Destination d = p.destination("Танзания");
        print(d.readLabel());
    }
}
