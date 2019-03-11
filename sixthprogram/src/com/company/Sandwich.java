package com.company;
import static com.company.util.Print.*;

class Meal {
    Meal() {print("Meal()");}
}

class Bread {
    Bread() {print("Bread()");}
}

class Cheese {
    Cheese() {print("Cheese()");}
}

class Letucce {
    Letucce() {print("Letucce()");}
}

class Lunch extends Meal {
    Lunch() {print("Lunch()");}
}

class PortableLunch extends Lunch {
    PortableLunch() {print("PortableLunch()");}
}

public class Sandwich  extends PortableLunch{
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Letucce l = new Letucce();
    public Sandwich() {print("Sandwich()");}
    public static void main(String[] args) {
        new Sandwich();
    }

}
