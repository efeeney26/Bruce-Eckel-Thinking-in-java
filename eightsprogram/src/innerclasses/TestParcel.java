package innerclasses;
import static innerclasses.util.Print.*;

interface Destination {
    String readLabel();
}

interface Contents {
    int value();
}

class Parcel3 {
    private class PContents implements Contents {
        private int i = 11;
        public int value() {return i;}
    }
    protected class PDestionation implements Destination {
        private String label;
        private PDestionation(String label) {this.label = label;}
        public String readLabel() {return label;}
    }
    public Destination destination(String s) {return new PDestionation(s);}
    public Contents contents() {return new PContents();}
}

public class TestParcel {
    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
        Contents c = p.contents();
        Destination d = p.destination("Тасмания");
        //Parcel3.PContents pc = p.new PContents();//доступ к классу невозможен из другого класса, т.к. PContents - приватный
        //Parcel3.PDestionation pd = p.new PDestionation();//доступ к классу protected, из другого класса к нему не добраться(только если еэто не наследник класса)
        print(d.readLabel());
    }
}
