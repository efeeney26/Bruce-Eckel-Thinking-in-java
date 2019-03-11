package arrays;
import java.util.Arrays;

import static arrays.util.Print.*;
//сравнение контейнеров и массивов

public class ArrayOptions {
    //массивы объектов
    public static void main(String[] args) {
        BerylliumSphere[] a;
        BerylliumSphere[] b = new BerylliumSphere[5];
        //ссылки в массиве автоматически инициализируются в null
        print("b: " + Arrays.toString(b));
        BerylliumSphere[] c = new BerylliumSphere[4];
        for (int i = 0; i < c.length; i++) {
            if(c[i] == null)//ПРоверка ссылки на действительность
                c[i] = new BerylliumSphere();
        }
        //Агрегатная инициализация
        BerylliumSphere[] d = {new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()};
        //Динамическая агрегатная инициадизация
        a = new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere(),  new BerylliumSphere()};
        print("a.length = " + a.length);
        print("b.length = " + b.length);
        print("c.length = " + c.length);
        print("d.length = " + d.length);
        a = d;
        print("a.length = " + a.length);
        //массивы примитивов
        int[] e;//ссылка null
        int[] f = new int[5];
        //примитивы в массиве автоматически инициализируются нулями
        print("f: " + Arrays.toString(f));
        int[] g = new int[4];
        for (int i = 0; i < g.length; i++)
            g[i] = i*i;
        int[] h = {11, 47, 93};
        //ошибка компиляции переменная e не инициализирована
        //print("e.length :" + e.length);
        print("f.length :" + f.length);
        print("g.length :" + g.length);
        print("h.length :" + h.length);
        e = h;
        print("e.length :" + e.length);
        e = new int[]{1, 2};
        print("e.length :" + e.length);
    }
}
