package collections;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import static collections.util.Print.*;
//инициализация LinkedHashSet

class Government implements Generator<String> {
    String[] foundation = ("strange women lying in ponds " + "distributing swords").split(" ");
    private int index;
    public String next() {return foundation[index++];}
}

public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<String>(
                new CollectionData<String>(new Government(), 7)
        );
        Collections.addAll(CollectionData.list(new Government(), 7));
        print(set);
    }
}
