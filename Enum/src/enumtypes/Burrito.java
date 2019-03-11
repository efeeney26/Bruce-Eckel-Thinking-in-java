package enumtypes;
import enumtypes.enumetated.Spiciness;

import static enumtypes.enumetated.Spiciness.*;

import static enumtypes.util.Print.*;

//статическое импортирование и перечисления


public class Burrito {
    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito is " + degree;
    }

    public static void main(String[] args) {
        print(new Burrito(NOT));
        print(new Burrito(MEDIUM));
        print(new Burrito(HOT));
    }
}
