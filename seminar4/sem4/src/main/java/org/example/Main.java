package org.example;

import java.io.File;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные пользователя в формате (Иванов И.И. 32 М) или Q для выхода");
        LinkedList<String> fname = new LinkedList<>();
        LinkedList<String> sname = new LinkedList<>();
        LinkedList<String> lname = new LinkedList<>();
        LinkedList<Integer> age = new LinkedList<>();
        LinkedList<Boolean> gender = new LinkedList<>();
        LinkedList<Integer> id = new LinkedList<>();
        while (true){
            String in = scanner.nextLine();
            if (in.toLowerCase().equals("q")) break;
            String[] str = in.split(" ");
            id.add(age.size());
            fname.add(str[0]);
            sname.add(str[1]);
            lname.add(str[2]);
            age.add(Integer.parseInt(str[3]));
            gender.add(str[4].toLowerCase().contains("м"));
        }
        for (int i = 0; i < age.size(); i++) {
            System.out.println(fname.get(i)+ " " + sname.get(i) + " " + lname.get(i) + " ");
        }
    }
}