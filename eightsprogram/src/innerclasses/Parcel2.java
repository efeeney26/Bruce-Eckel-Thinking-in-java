package innerclasses;
import static innerclasses.util.Print.*;

public class Parcel2 {
    class Contents {
        private int i = 11;
        public int value() {return i;}
    }
    class Destination {
        private String label;
        Destination(String label) {this.label = label;}
        String readLabel() {return label;}
    }
    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        Contents c = p.new Contents();//для создания экзмемпляра внутреннего класса необходима ссылка на внешний класс
        Destination d = p.new Destination("Танзания");//для создания экзмемпляра внутреннего класса необходима ссылка на внешний класс
        print(d.readLabel());
        print(c.value());
    }
}
