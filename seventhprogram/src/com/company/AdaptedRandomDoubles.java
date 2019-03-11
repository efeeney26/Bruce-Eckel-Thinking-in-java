package com.company;
import java.nio.CharBuffer;
import java.util.Random;

import static com.company.util.Print.*;

class RandomDoubles {
    private static Random rand = new Random(47);
    public double next() { return rand.nextDouble(); }
}
//Создание класса с помощью паттерна адаптер посредством наследования
public class AdaptedRandomDoubles extends RandomDoubles
implements Readable{
    private int count;
    public AdaptedRandomDoubles(int count) {this.count = count;}
    public int read(CharBuffer cb) {
        if(count-- == 0)
            return (-1);
        String result = Double.toString(next()) + " ";
        cb.append(result);
        return result.length();
    }
}
