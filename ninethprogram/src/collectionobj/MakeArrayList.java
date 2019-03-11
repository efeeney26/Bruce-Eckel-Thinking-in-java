package collectionobj;
import static collectionobj.util.Print.*;
import java.util.*;
//методы ArrayList

public class MakeArrayList {
    public static ArrayList<Integer> arrayList(int size) {
        Random random = new Random(47);
        ArrayList<Integer> collection = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++)
            collection.add(random.nextInt(20));
        return (collection);
    }
    public static void main() {
        ArrayList<Integer> arr = MakeArrayList.arrayList(10);
        arr.add(6);
        print(arr);
        arr.remove(1);
        print(arr);
        print(arr.indexOf(18));
        arr.add(3, 4);
        print(arr);
        print(arr.subList(2, 4));
        Collections.sort(arr);
        print(arr);
        Collections.shuffle(arr);
        print(arr);
        arr.removeAll(arr);
        print(arr);
    }
}
