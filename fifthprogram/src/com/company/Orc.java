package com.company;
import static com.company.util.Print.*;

//protected виден для производных класса и для соседей внутри пакета. Не виден для пользователей класса(не вызывается из объекта класса)
class Villain {
    private String name;
    protected void set(String nm) {name = nm;}
    public Villain(String name) {this.name = name;}
    public String toString() {
        return "Я обект Villain и мое имя " + name;
    }
}

public class Orc extends Villain {
    private  int orcNumber;
    public Orc(String name, int orcNumber) {
        super(name);
        this.orcNumber = orcNumber;
    }
    public void change(String name, int orcNumber) {
        set(name);
        this.orcNumber = orcNumber;
    }
    public String toString() {
        return "Orc " + orcNumber + ": " + super.toString();
    }
}
