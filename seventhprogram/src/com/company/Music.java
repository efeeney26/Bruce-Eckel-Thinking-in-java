package com.company;
import static com.company.util.Print.*;

//Абстрактный класс Instrument. В нем создается общий интерфейс для последующей работы с производными типами(производной тип брал основу и добвлял или переопределял свои методы и поля). НЕЛЬЗЯ ПОЛУЧИТЬ ЭКЗЭМПЛЯР АБСТРАКТНОГО КЛАССА, В АБСТРАКТНЫХ КЛАССАХ МОГУТ БЫТЬ АБСТРАКТНЫЕ МЕТОДЫ
abstract class Instrument {
    private int i;
    abstract public void play();
    public String what() {return "Instrument";}
    abstract public void adjust();
}

class Wind extends Instrument {
    public void play() {print("Wind play");}
    public String what() {return "Wind";}
    public void adjust(){}
}

class Percussion extends Instrument {
    public void play() {print("Percussion play");}
    public String what() {return "Percussion";}
    public void adjust(){}
}

class Stringed extends Instrument {
    public void play() {print("Stringed play");}
    public String what() {return "Stringed";}
    public void adjust(){}
}

class Brass extends Wind {
    public void play() {print("Brass play");}
    public void adjust() {print("Brass adjust");}
}

class Woodwind extends Wind {
    public void play() {print("Woodwind play");}
    public String what() {return "Woodwind";}
}
public class Music {
    static void tune(Instrument i) {
        i.play();
    }
    static void tuneAll(Instrument[] e) {
        for (Instrument x: e) {
            tune(x);
        }
    }
    public static void main(String[] args) {
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
}
