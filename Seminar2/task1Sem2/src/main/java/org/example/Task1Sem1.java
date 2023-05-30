package org.example;
//* Дана строка sql-запроса "select * from students where ". Сформируйте часть
//        * WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены
//        * ниже в виде json строки.
//        * Если значение null, то параметр не должен попадать в запрос.
//        * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia",
//        * "city":"Moscow", "age":"null"}

import java.util.Random;
import java.util.Scanner;

//import java.util.HashMap;
//import java.util.Map;
//
//public class Task1Sem1 {
//    public static void main(String[] args) {
//        StringBuilder resultQuery = new StringBuilder();
//        String beginQuery = "select * from students where ";
//        Map<String, String> filterJson = new HashMap<>();
//        filterJson.put("name", "Ivanov");
//        filterJson.put("country", "Russia");
//        filterJson.put("city", "Moscow");
//        filterJson.put("age", null);
//        resultQuery.append(beginQuery);
//        for (String key : filterJson.keySet()) {
//            if (filterJson.get(key) != null) {
//                resultQuery.append(String.format("%s = '%s' and ", key, filterJson.get(key)));
//            }
//        }
//        resultQuery.delete(resultQuery.length() - 4, resultQuery.length());
//        System.out.println(resultQuery);
//    }
//
//}
public class Task1Sem1 {
    public static void main(String[] args) {
        System.out.print("Enter the size of the array: ");
        Scanner console = new Scanner(System.in);
        int sizeArr = console.nextInt();
        int[] myArr = createArrayRND(sizeArr);
        inputArray("initial array: ", myArr);
        System.out.println();
        sortArrayBubbleCons(myArr);
    }

    private static void sortArrayBubbleCons(int[] arr) {
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
                inputArray("interior FOR", arr);
            }
            inputArray("external FOR", arr);
        }
    }

    private static void inputArray(String msg, int[] arr) {
        System.out.println(msg + ":");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int[] createArrayRND(int size) {
        int[] arr = new int[size];
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rnd.nextInt(100);
        }
        return arr;
    }
}