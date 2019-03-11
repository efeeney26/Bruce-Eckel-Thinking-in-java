package com.company;

import java.util.*;

public class Main {
    static Random rand = new Random(47);
    static int[] getArr (int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = rand.nextInt(100);
        return arr;
    }

    static int compare (int value) {
        if (value > 10)
            return (1);
        return (0);
    }

    static boolean condition () {
        boolean result = Math.random() < 0.99;
        System.out.println("Result: " + result);
        return result;
    }
    public static void main(String[] args) {
         //System.out.println(compare(20));

        /*while (condition())
            System.out.println("Inside condition");
        System.out.println("Outside condition");*/

        /*Random rand = new Random();
        float f[] = new float[10];
        for (int i = 0; i < 10; i++) 
            f[i] = rand.nextFloat();
        for (float x: f) {
            System.out.println(x);
        }*/

        /*String str = "fuck you";
        for (char c: str.toUpperCase().toCharArray()) {
            System.out.println(c);
        }*/

        /*for (int i: getArr(10)) {
            System.out.print(i + ",");
        }*/

        /*for (int i = 0; i < 100; i++) {
            int c = rand.nextInt(26) + 'a';

        }*/

        for (int i = 0; i < 10; i++) {
            char c = (char)(rand.nextInt(26) + 'a');
            System.out.print(c + ", " + (int)c + ": ");
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u': System.out.println("гласная");
                          break;
                case 'y':
                case 'w': System.out.println("Условно гласная");
                          break;
                default: System.out.println("согласная");
                         break;
            }
        }



        
    }
}
