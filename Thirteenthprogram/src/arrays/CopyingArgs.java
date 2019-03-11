package arrays;
import java.util.Arrays;
import static arrays.util.Print.*;
import java.util.Collection;
public class CopyingArgs {
    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i, 47);//заполняет эл-ом val длину массива
        Arrays.fill(j, 99);
        print(Arrays.toString(i));
        print(Arrays.toString(j));
        System.arraycopy(i, 0, j, 0, i.length);//копирует i в j, с указанием длины длины исходного массива
        print(Arrays.toString(j));
        int[] arr1 = new int[7];
        Arrays.fill(arr1, 47);
        int[] arr2 = new int[7];
        Arrays.fill(arr2, 47);
        print(Arrays.equals(arr1, arr2));
        int[] arr3 = {4, 6, 3, 99, 1, 11};
        Arrays.sort(arr3);//сортировка массива
        print(Arrays.toString(arr3));
        print("arr3[" + Arrays.binarySearch(arr3, 11) + "] = 11");//ищет индекс по ключу(значению)

    }
}
