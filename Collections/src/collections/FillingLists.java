package collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static collections.util.Print.*;
//методы Collections.fill и Collections.nCopies

class StringAddress {
    private String s;
    public StringAddress(String s) {this.s = s;}
    public String toString() {return super.toString() + " " + s;}
}

public class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<StringAddress>(
                Collections.nCopies(4, new StringAddress("Hello"))
        );
        print(list);
        Collections.fill(list, new StringAddress("World"));//fill может только заменять объекты в списке, и не может добавлять новые элементы
        print(list);
    }
}

