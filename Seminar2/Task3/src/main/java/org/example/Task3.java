package org.example;
//Пусть дан произвольный список целых чисел.
//
//        1) Нужно удалить из него чётные числа
//        2) Найти минимальное значение
//        3) Найти максимальное значение
//        4) Найти среднее значение

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {

        ArrayList<Integer> listInt = new ArrayList<>();
        listInt = createArrayListRND();
        System.out.println("Source list:" + listInt);
        System.out.println("Even numbers removed:" + removesEven(listInt));
        listInt.sort(Comparator.naturalOrder());
        System.out.println("Minimum number:" + listInt.get(0));
        System.out.println("Maximum number:" + listInt.get(listInt.size()-1));
        System.out.printf("Average Value:" + "%.2f", findsAverageValue(listInt));
    }

    private static double findsAverageValue(ArrayList<Integer> list) {
        double sum = 0.0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
        }
        return sum / list.size();
    }

    private static ArrayList<Integer> removesEven(ArrayList<Integer> list) {
        int i = 0;
        while (i < list.size()){
            if (list.get(i) % 2 == 0)
                list.remove(i);
            else i++;
        }
        return list;
    }

    private static ArrayList<Integer> createArrayListRND() {
        int n = new Random().nextInt(20);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Random().nextInt(20));
        }
        return list;
    }
}