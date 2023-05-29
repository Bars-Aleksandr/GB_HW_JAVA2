package org.example;

import java.util.ArrayList;
import java.util.Random;

//Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
//Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
// Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
// Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
public class Task1 {
    public static void main(String[] args) {
        int i = new Random().nextInt(2000);
        System.out.println("Random number = " + i);
        int n = findHighBitNumber(i);
        System.out.println("MSb = " + n);
    }

    public static int findHighBitNumber(int dec) {
        return intToBinRevers(dec).size()-1;
    }

    private static ArrayList intToBinRevers(int i) {

        ArrayList arrBins = new ArrayList();
        int count = 0;
        if (i !=0) {
            while (i != 0) {
                arrBins.add(i % 2);
                i = i / 2;
                count += 1;
            }
        } else {
            arrBins.add(i);
        }
        return arrBins;
    }
}