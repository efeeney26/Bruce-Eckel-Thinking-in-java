package com.company;
import static com.company.util.Print.*;

class Instrument {
    public void play() {print("Instrument.play()");}
    static void tune(Instrument i) {
        i.play();
    }
}

public class Wind extends Instrument {
    public static void main(String[] args) {
        Wind flute = new Wind();
        Instrument.tune(flute);//восходящее преобразование
    }
}
