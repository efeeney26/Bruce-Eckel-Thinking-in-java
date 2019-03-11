package arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static arrays.util.Print.*;

//возможность создания массива параметризованных типов
public class ArrayOfGenerics {
    public static void main(String[] args) {
        List<String>[] lists;
        List[] la = new List[10];
        lists = (List<String>[])la;//предупреждение о непроверенном преобразовании
        lists[0] = new ArrayList<String>();
        //lists[1] = new ArrayList<Integer>();//ошибка на стадии компиляции
        Object[] objects = lists;
        objects[1] = new ArrayList<Integer>();

        //создание массива параметризованных типов
        List<BerylliumSphere>[] lists1 = (List<BerylliumSphere>[])new List[10];//предупреждение о непроверенном преобразовании
        for (int i = 0; i < lists1.length; i++) {
            lists1[i] = new ArrayList<BerylliumSphere>(2);
            lists1[i].add(new BerylliumSphere());
            lists1[i].add(new BerylliumSphere());
        }
        print(Arrays.toString(lists1));
    }
}
