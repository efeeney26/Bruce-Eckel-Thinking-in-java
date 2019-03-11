package arrays;
import java.util.Random;

import static arrays.util.Print.*;
//рандомный генератор
public class RandomGenerator implements Generator<Integer> {
    private Random random = new Random(47);
    public Integer next() {return random.nextInt(20);}
}
