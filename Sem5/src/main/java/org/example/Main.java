package org.example;
//Урок 5. Хранение и обработка данных ч2: множество коллекций Map:
//
//        Создать множество, ключ и значение строки. Добавить шесть элементов.
//        Вывести в консоль значения.
//        Добавить ко всем значениям символ "!".
//        Создать второе множество с таким же обобщением.
//        Ключи второго множества частично совпадают с ключеми первого.
//        Объеденить значения во втором множестве и первом если ключи совподают.
//        Вывести результат в консоль.
//        Реализовать с использованием и без использования метода merge.

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>();
        HashMap<String,String> hashMap2 = new HashMap<>();
        hashMap = inputMapKStrVStr();
        outputValueMap(hashMap);
        hashMap = addValueSymbol(hashMap, "!");
        outputValueMap(hashMap);
        hashMap2 = createHashMap2();
        outputMap(hashMap2);
        methodWithoutMerge(hashMap, hashMap2);
        methodWithMerge(hashMap, hashMap2);
    }

    private static void methodWithMerge(HashMap<String, String> hash1, HashMap<String, String> hash2) {
        hash2.forEach((kH2, vH2) -> hash1.merge(kH2, vH2,(v1, v2) -> vH2 + " " + v2));
        System.out.println("C методом merge");
        outputMap(hash2);
    }

    //        Объеденить значения во втором множестве и первом если ключи совподают.
    private static void methodWithoutMerge(HashMap<String, String> hash1, HashMap<String, String> hash2) {
        hash1.forEach((kH1, vH1) -> hash2.computeIfPresent(kH1,(kH2, vH2) -> vH2 + " " + vH1));
        System.out.println("Без метода merge");
        outputMap(hash2);
    }


    private static HashMap<String, String> createHashMap2() {
        HashMap<String,String> hash = new HashMap<>();
        hash.put("left", "value left");
        hash.put("right", "value right");
        hash.put("down", "value down");
        hash.put("four", "value four");
        hash.put("five", "value five");
        hash.put("six", "value six");
        return hash;
    }

    private static HashMap<String, String> addValueSymbol(HashMap<String, String> hash, String s) {
        hash.forEach((k, v) -> hash.merge(k, v ,(v0, vN) -> v0 + s));
        return hash;
    }

    private static void outputValueMap(HashMap<String, String> hash) {
        System.out.println("Значения множества");
        hash.forEach((k, v) -> System.out.println(v));
    }

    private static void outputMap(HashMap<String, String> hash) {
        System.out.println("Множество: ключ - значение");
        hash.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    private static HashMap<String, String> inputMapKStrVStr() {
        HashMap<String,String> hash = new HashMap<>();
        String[] arr = new String[2];
        System.out.println("Введите значения множества в формате 'ключ : значение' ");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            System.out.println("Введите " + (i+1) + "-е значение");
            arr = scanner.nextLine().split(" : ");
            hash.put(arr[0], arr[1]);
        }
        return hash;
    }
}