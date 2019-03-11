package com.company;
import static com.company.util.Print.*;

import java.io.IOException;
import java.nio.*;
import java.util.Random;
import java.util.Scanner;
//интерфейсы как средство адаптации

public class RandowWords implements Readable {
    private static Random rand = new Random(47);
    private static final char[] capitals = "ABCDEFGHIGKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] lowers = "abcdefghigklmnopqrstuvwxyz".toCharArray();
    private static final char[] vowels = "aeiou".toCharArray();
    private int count;
    public RandowWords(int count) {this.count = count;}
    public int read(CharBuffer cb) {
        if(count-- == 0)
            return (-1);//Признак конца входных данных
        cb.append(capitals[rand.nextInt(capitals.length)]);
        for (int i = 0; i < 4; i++) {
            cb.append(lowers[rand.nextInt(lowers.length)]);
            cb.append(vowels[rand.nextInt(vowels.length)]);
        }
        cb.append(" ");
        return 10;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(new RandowWords(10));
        while (s.hasNext())
            print(s.next());
    }
}
