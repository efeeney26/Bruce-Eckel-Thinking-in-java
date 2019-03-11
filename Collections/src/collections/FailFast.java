package collections;
import static collections.util.Print.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

//демонстрация механизма срочного отказа
public class FailFast {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();//сначала заполни контейнер, пото проси iterator
        Iterator<String> it = c.iterator();
        c.add("An object");
        try {
            String s = it.next();
        }catch (ConcurrentModificationException e) {
            print(e);
        }
    }
}
