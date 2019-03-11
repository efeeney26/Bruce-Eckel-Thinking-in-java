package arrays;
import static arrays.util.Print.*;
//простая реализаци int генератора

public class CountingGenerator implements Generator<java.lang.Integer> {
    private int value = 0;
    public java.lang.Integer next() {return value++;}
}
