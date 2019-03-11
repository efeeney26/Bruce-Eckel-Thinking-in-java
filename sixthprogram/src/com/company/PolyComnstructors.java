package com.company;
import static com.company.util.Print.*;

class Glyph {
    void draw() {print("Glyph draw()");}
    Glyph() {
        print("Glyph() перед вызовом draw()");
        draw();//здесь будет неверный вызов метода, т.к. произойдет вызов draw не Gliph, а RoundGlyph, а там radius еще не инициализирован и поэтому равен 0
        print("Glyph() после вызовом draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;
    RoundGlyph(int r) {
        radius = r;
        print("RoundGlyph RoundGlyph(), radius = " + radius);
    }
    void draw() {
        print("RoundGlyph.draw, radius = " + radius);
    }
}

public class PolyComnstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
