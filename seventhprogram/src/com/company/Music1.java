package com.company;
import static com.company.util.Print.*;
//Интерфейс похож на абстракцию, только поля автоматически являются static и final, методы являются по умолчанию public

interface Instrument1 {
    int Value = 5;//константа времени компиляции, является static final
    void play();
    void adjust();
}

class Wind1 implements Instrument1 {
    public void play() {print(this + ".play()");}
    public String toString() {return "Wind1";}
    public void adjust() {print(this + ".adjust()");}
}

class Percussion1 implements Instrument1 {
    public void play() {print(this + ".play()");}
    public String toString() {return "Percussion1";}
    public void adjust() {print(this + ".adjust()");}
}

class Stringed1 implements Instrument1 {
    public void play() {print(this + ".play()");}
    public String toString() {return "Stringed1";}
    public void adjust() {print(this + ".adjust()");}
}

class Brass1 extends Wind1 {
    public String toString() {return "Brass1";}
}

class Woodwind1 extends Wind1 {
    public String toString() {return "Woodwind1";}
}

public class Music1 {
    static void tune(Instrument1 i) {
        i.play();
    }
    static void tuneAll(Instrument1[] e) {
        for (Instrument1 x: e) {
            tune(x);
        }
    }

    public static void main(String[] args) {
        Instrument1[] arr = {
                new Wind1(),
                new Percussion1(),
                new Stringed1(),
                new Brass1(),
                new Woodwind1()
        };
        tuneAll(arr);
    }
}
