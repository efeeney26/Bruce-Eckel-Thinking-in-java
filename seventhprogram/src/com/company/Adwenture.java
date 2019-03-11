package com.company;
import com.company.util.Print.*;
//создаем новый класс на основе реального класса и нескольких интерфейсов(множественное наследование)

interface CanFight {
    void fight();
}

interface CanSwim {
    void swim();
}

interface CanFly {
    void fly();
}

class ActionCharacter {
    public void fight() {}
}

class Hero extends ActionCharacter
      implements CanFight, CanFly, CanSwim {
    public void swim() {}
    public void fly() {} //нет fight, т.к. наследуется из реального класса ActionCharacter
}

public class Adwenture {
    public static void t(CanFight x) {x.fight();}
    public static void u(CanSwim x) {x.swim();}
    public static void v(CanFly x) {x.fly();}
    public static void w(ActionCharacter x) {x.fight();}
    public static void main(String[] args) {
        Hero h = new Hero();
        t(h);
        u(h); //объект h наследует и от интерфейсов и от обычных(реальных) классов
        v(h);
        w(h);
    }
}
