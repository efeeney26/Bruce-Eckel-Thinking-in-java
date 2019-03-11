package innerclasses;
import static innerclasses.util.Print.*;
//реализация внутреннего класса с использвонием конструктора

class Wrapping {
    private int i;
    Wrapping(int i) {this.i = i;}
    public int value() {return i;}
}

public class Parcel7 {
    public Wrapping wrapping(int x) {
        return new Wrapping(x) {
            public int value() {return super.value() * 47;}
        };
    }
    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Wrapping w = p.wrapping(10);
        print(w.value());
    }
}
