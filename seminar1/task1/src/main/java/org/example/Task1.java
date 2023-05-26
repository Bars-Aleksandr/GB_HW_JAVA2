package org.example;

import java.util.Random;

//Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
public class Task1 {
    public static void main(String[] args) {
        int i = new Random().nextInt(2000);
    }
}