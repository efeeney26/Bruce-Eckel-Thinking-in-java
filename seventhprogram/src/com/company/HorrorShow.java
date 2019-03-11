package com.company;
import static com.company.util.Print.*;
//расширение интерфейса через наследование

interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {//расширение Monster
    void destroy();
}

interface Lethal {
    void kill();
}

class DragonZilla implements DangerousMonster {//интерфейс реализуется классом DragonZilla
    public void menace() {}
    public void destroy() {}
}

interface Vampire extends DangerousMonster, Lethal {//extands может принимать несколько базовых интерфейсов, НО ТОЛЬКО ОДИН БАЗОВЫЙ КЛАСС
    void drinkBlood();
}

class VeryBadVampire implements Vampire{
    public void menace() {}
    public void destroy() {}
    public void kill() {}
    public void drinkBlood() {}
}

public class HorrorShow {
    static void u(Monster b) {b.menace();}
    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }
    static void w(Lethal l) {
        l.kill();
    }
    public  static void main(String[] args) {
        DangerousMonster dangerousMonster = new DragonZilla();
        u(dangerousMonster);
        v(dangerousMonster);
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }
}
