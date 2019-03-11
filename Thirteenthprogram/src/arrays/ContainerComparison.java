package arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static arrays.util.Print.*;

//сравнение контейнеров и массивов

class BerylliumSphere {
    private static long counter = 0;
    private final long id = counter++;
    public String toString() {return getClass().getCanonicalName() + " " + id;}
}

public class ContainerComparison {
    public static void main(String[] args) {
        BerylliumSphere[] spheres = new BerylliumSphere[10];
        for (int i = 0; i < 5; i++)
            spheres[i] = new BerylliumSphere();
        print(Arrays.toString(spheres));
        print(spheres[4]);
        List<BerylliumSphere> spheres1 = new ArrayList<BerylliumSphere>();
        for (int i = 0; i < 5; i++) {
            spheres1.add(new BerylliumSphere());
        }
        print(spheres1);
        print(spheres1.get(4));
        int[] ints = {0, 1, 2, 3, 4, 5};
        print(Arrays.toString(ints));
        print(ints[4]);
        List<Integer> ints2 = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5));
        ints2.add(97);
        print(ints2);
        print(ints2.get(4));

    }
}
