package org.example;

import java.io.*;
import java.util.LinkedList;

//    1.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"
//    2.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возрас и пол в отдельных списках.
//    3.Отсортировать по возрасту используя дополнительный список индексов.
//    4.Отсортировать по полу используя дополнительный список индексов.
//    5.*Сортировка по полу и возрасту.
public class Main {
    static LinkedList<Integer> id = new LinkedList<>();
    static LinkedList<String> lastname = new LinkedList<>();
    static LinkedList<String> firstname = new LinkedList<>();
    static LinkedList<String> patronymic = new LinkedList<>();
    static LinkedList<Integer> age = new LinkedList<>();
    static LinkedList<String> gender = new LinkedList<>();
    public static void main(String[] args) throws FileNotFoundException {
        readDataFile();
        writeDataConsole();
        sortAge();
        System.out.println("Sorted list by age: ");
        writeDataConsole();
        System.out.println("Sorted list by gender: ");
        sortGender();
        writeDataConsole();
    }

    private static void sortGender() {
        for (int i = 0; i < id.size() / 2; i++) {
            if (gender.get(id.get(i)).equalsIgnoreCase("м")) {
                gender.addLast(gender.get(id.get(i)));
                gender.remove(id.get(i));
                id.addLast(id.get(i));
                id.remove(id.get(i));
                i--;
            }
        }
    }

    private static void sortAge() {
        for (int i = 0; i < id.size()-1; i++) {
            int maxAge = age.get(id.get(i));
            int indexMax = i;
            for (int j = i + 1; j < id.size(); j++) {
                if (maxAge > age.get(id.get(j))){
                    indexMax = j;
                    maxAge = age.get(id.get(j));
                }
            }
            if (indexMax != i){
                int tmp = id.get(i);
                id.set(i, id.get(indexMax));
                id.set(indexMax, tmp);
            }

        }
    }

    private static void writeDataConsole() {
        for (int i = 0; i < id.size(); i++) {
            System.out.println(id.get(i) + "-id  " + lastname.get(id.get(i)) + " " + firstname.get(id.get(i)).toUpperCase().charAt(0) + ". " + patronymic.get(id.get(i)).toUpperCase().charAt(0) + ". " + age.get(id.get(i)) + " " + gender.get(id.get(i)));
        }
    }

    private static void readDataFile() throws FileNotFoundException {
        try {
            BufferedReader br = new BufferedReader( new FileReader("UserData.txt"));
            String str;
            String[] strArr;
            while ((str = br.readLine()) != null){
                strArr = str.split(" ");
                id.add(lastname.size());
                lastname.add(strArr[0]);
                firstname.add(strArr[1]);
                patronymic.add(strArr[2]);
                age.add(Integer.valueOf(strArr[3]));
                gender.add(strArr[4]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}