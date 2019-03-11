package innerclasses;
import static innerclasses.util.Print.*;
//определяем класс внутри метода
public class Parcel4 {
    public Destination dest(String s) {
        class PDestionation implements Destination {
            private String label;
            private PDestionation(String label) {this.label = label;}
            public String readLabel() {return label;}
        }
        return new PDestionation(s);
    }
    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Destination d = p.dest("Танзания");
        print(d.readLabel());
    }
}
