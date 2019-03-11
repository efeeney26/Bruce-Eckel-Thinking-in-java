package innerclasses;
import static innerclasses.util.Print.*;
//реализация внутренних классов
public class Parcell {
    class Contents {
        private int i = 11;
        public int value() {return i;}
    }
    class Destination {
        private String label;
        Destination(String label) { this.label = label; }
        String readLabel() {return  label;}
    }
    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);
        print(d.readLabel());
    }
    public static void main(String[] args) {
        Parcell p = new Parcell();
        p.ship("Тасмания");
    }

}


