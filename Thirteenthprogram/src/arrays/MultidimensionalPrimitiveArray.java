package arrays;
import java.util.Arrays;
import java.util.Random;

import static arrays.util.Print.*;
//создание многомерного массива

public class MultidimensionalPrimitiveArray {
    public static void main(String[] args) {
        int[][]a = {
                {1, 2, 3},
                {4, 5, 5}
        };
        print(Arrays.deepToString(a));
    }
}


