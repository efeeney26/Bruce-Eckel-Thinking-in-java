package arrays;
import java.util.Arrays;
import java.util.Random;
//возврат массива
import static arrays.util.Print.*;

public class IceCream {
    private static Random rand = new Random(47);
    static final String[] FLAVOURS = {
            "Chocolate", "Strawberry", "Vanilla", "Orange", "ApplePie", "BubbleGum", "Cranberry"
    };

    public static String[] flavorSet(int n) {
        if (n > FLAVOURS.length)
            throw new IllegalArgumentException("Set too big");
        String[] results = new String[n];
        boolean[] picked = new boolean[FLAVOURS.length];
        for (int i = 0; i < n; i++) {
            /*int t;
            do {
                t = rand.nextInt(FLAVOURS.length);
            } while (picked[t]);
            results[i] = FLAVOURS[t];
            picked[t] = true;*/


            results[i] = FLAVOURS[rand.nextInt(FLAVOURS.length)];
        }
        return results;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            print(Arrays.toString(flavorSet(3)));
        }
    }
}

