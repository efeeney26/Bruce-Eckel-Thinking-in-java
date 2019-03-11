package generics;
import static generics.util.Print.*;
//тестирование кортежей
class Amphibian {}
class Vehicle {}

public class TestTuples {
    static TwoTuple<String, Integer> f() {
        return new TwoTuple<String, Integer>("hi", 47);
    }
    static ThreeTuple<Amphibian, String, Integer>g() {
        return new ThreeTuple<Amphibian, String, Integer>(new Amphibian(), "hi", 47);

    }
    static FourTuple<Vehicle, Amphibian, String, Integer>h() {
        return new FourTuple<Vehicle, Amphibian, String, Integer>(new Vehicle(), new Amphibian(), "hi", 47);

    }
    static FiveTuple<Vehicle, Amphibian, String, Integer, Double>k() {
        return new FiveTuple<Vehicle, Amphibian, String, Integer, Double>(new Vehicle(), new Amphibian(), "hi", 47, 5.6);

    }
    public static void main() {
        TwoTuple<String, Integer> ttsi = f();
        print(ttsi);
        //ttsi.first = "there"//ошибка компиляции, first - константа
        print(g());
        print(h());
        print(k());
    }
}
