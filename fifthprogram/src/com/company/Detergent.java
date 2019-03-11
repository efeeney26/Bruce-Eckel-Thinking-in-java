package com.company;
import static com.company.util.Print.*;

public class Detergent extends Cleanser {
    public void scrub() {
        append("Detergent.scrub()");
        super.scrub();
    }
    public void foam() {
        append("foam()");
    }
    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.delute(); x.apply();x.scrub();x.foam();
        print(x);
        print("Check the base class");
    }
}
