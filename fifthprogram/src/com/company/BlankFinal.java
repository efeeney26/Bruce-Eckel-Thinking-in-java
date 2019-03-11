package com.company;

class Poppet {
    private int i;
    Poppet(int i) { this.i = i;}
    public void spin() {}
}
final class Dinosaur {
    int i = 1,
        j = 12;
    void f() {}
}

class Rex /*extends Dinosaur*/ { //нельзя наследовать от final класса Dinsaur и нельзя его расширять
    Dinosaur rex  = new Dinosaur();
    void f() {
        rex.i = 5;//но можно переопределять его поля
    }
}
public class BlankFinal {
    private final int i = 0;
    private final int j;//пустая константа
    private final Poppet p;//пустая константа
    //Пустые константы надо инициализировать в конструкторе
    public BlankFinal() {
        j = 1;
        p = new Poppet(1);
    }
    public BlankFinal(int x) {
        this.j = x;
        this.p = new Poppet(x);
    }
    void with(final Poppet p) {
        //p = new Poppet(1);//запрещено, т.к. p - final(константа)
    }
    void without(Poppet p) {
        p = new Poppet(1);//разрешено, p - не final
        p.spin();
    }
    //void f(final int i){i++;}//нельзя изменять i
    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
    }

}
