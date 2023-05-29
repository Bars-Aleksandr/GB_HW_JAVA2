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
        System.out.println("Short.MAX_VALUE = " + Short.MAX_VALUE);
        //int[] m1 = new int[quantityMultiplesNum(i, Short.MAX_VALUE, n)];
        printArrayInt(arrMultiplesNum(i, (int) Short.MAX_VALUE, n));
    }

    public static int[] arrMultiplesNum(int from, int to, int mult){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = from; i < to; i++) {
            if (i % mult == 0) {
                list.add(i);
            }
        }
        return arrayListToIntArray(list);
    }
    public static int[] arrayListToIntArray(ArrayList<Integer> arrList){
        int[] arrInt = new int[arrList.size()-1];
        for (int i = 0; i <arrList.size()-1 ; i++) {
            arrInt[i] = arrList.get(i);
        }
        return arrInt;
    }
    public static void printArrayInt(int[] arr){
        System.out.println("Array of multiples:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static int findHighBitNumber(int dec) {
        return intToBinRevers(dec).size()-1;
    }

    private static ArrayList intToBinRevers(int i) {

        ArrayList arrBins = new ArrayList();
        if (i !=0) {
            while (i != 0) {
                arrBins.add(i % 2);
                i = i / 2;
            }
        } else {
            arrBins.add(i);
        }
        return arrBins;
    }
//    private static int quantityMultiplesNum(int from, int to, int mult){
//        int count = 0;
//        for (int i = from; i < to; mult++) {
//            if (i % mult == 0) {
//                count++;
//            }
//        }
//        return count;
//    }
}