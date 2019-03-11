package typesinfo;
import java.util.Arrays;
import java.util.List;
import static typesinfo.util.Print.*;
//работа полиморфизм
abstract class Shape {
    void draw() {print(this + ".draw()");}
    abstract public String toString();
}

class Circle extends Shape {
    public String toString() {return getClass().getSimpleName();}
}

class Triangle extends Shape {
    public String toString() {return getClass().getSimpleName();}
}

class Square extends Shape {
    public String toString() {return getClass().getSimpleName();}
}

public class Shapes {
    public static void main() {
        List<Shape> shapes = Arrays.asList(new Circle(), new Triangle(), new Square());
        for (Shape s: shapes) {
            s.draw();
        }
    }
}