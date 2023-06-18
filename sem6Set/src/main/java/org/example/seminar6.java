package org.example;


import java.util.Iterator;
import java.util.Random;

//  Разработать программу, имитирующую поведение коллекции HashSet.
//  В программе содать метод add добавляющий элемент,
//  метод toString возвращающий строку с элементами множества и метод позволяющий читать элементы по индексу.
//  *Реализовать все методы из семинара.
//  Формат данных Integer.
public class seminar6 {
    public static void main(String[] args) {
    MySet<Integer> mySet = new MySet();
        for (int i = 0; i < 10; i++) {
            mySet.addMySet(new Random().nextInt(10));
        }
//        for (int i = 0; i < 10; i++) {
//            System.out.println(mySet.removeMySet(new Random().nextInt(10)));
//        }
//        for (int i = 0; i < 10; i++) {
//            System.out.println(mySet.containsMySet(new Random().nextInt(10)));
//        }
        System.out.println(mySet);
        Iterator<Integer> iter = mySet.iterator();
        while (iter.hasNext()){
            int a = iter.next();
            if (a % 2 ==0){
                System.out.print(a + " ");
            }
        }
        System.out.println();
        System.out.println(mySet.readByIndex(1));
    }
}