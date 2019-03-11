package arrays;

import java.util.Arrays;
import java.util.Random;

import static arrays.util.Print.print;

class ThreeDWithNew {
    private static Random rand = new Random(47);
    public static void main(String[] args) {
        int[][][] a = new int[2][3][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 2; k++) {
                    a[i][j][k] = rand.nextInt(20);
                }
            }
        }
        print(Arrays.deepToString(a));
    }
}