package typesinfo;
import java.util.Random;

class Building { void f() {}}
class House extends Building {void f1() {}}

public class ClassCasts {
    public static void main() {
        Building b = new House();
        Class <House> houseType = House.class;
        houseType.cast(b).f1();
    }
}
