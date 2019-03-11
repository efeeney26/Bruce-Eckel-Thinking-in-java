package collections;

import java.util.AbstractList;
import java.util.ArrayList;
import static collections.util.Print.*;
//Список произвольной длины, содержащий тестовые данные

public class CountingIntegerList extends AbstractList<Integer> {
    private int size;
    public CountingIntegerList(int size) {this.size = size < 0 ? 0 : size;}
    @Override
    public Integer get(int index) {
       return Integer.valueOf(index);
    }

    @Override
    public int size() {
        return size;
    }
    public static void main(String[] args) {
        print(new CountingIntegerList(30));
    }
}
