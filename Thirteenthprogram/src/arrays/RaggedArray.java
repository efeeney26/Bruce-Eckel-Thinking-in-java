package arrays;
import java.util.Arrays;
import java.util.Random;

import static arrays.util.Print.*;
//ступенчатый массив(Векторы имеют разную длину)
public class RaggedArray {
    private static Random rand = new Random(47);

    public static void main(String[] args) {

        int[][][] a = new int[rand.nextInt(7)][][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new int[rand.nextInt(5)][];
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = new int[rand.nextInt(5)];
                for (int k = 0; k < a[i][j].length; k++) {
                    a[i][j][k] = rand.nextInt(10);
                }
            }
        }
        print(Arrays.deepToString(a));
    }
}


