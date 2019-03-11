package collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Integers implements Generator<Integer> {
    private final int size;
    private int number;
    private int[] sequence;
    private Random rand = new Random(47);
    public Integers(int size) {
        this.size = size;
        sequence = new int[size];
        for (int i = 0; i < size; i++)
            sequence[i] = rand.nextInt(100);
    }
    @Override
    public Integer next() {
        return sequence[number++];
    }
}
