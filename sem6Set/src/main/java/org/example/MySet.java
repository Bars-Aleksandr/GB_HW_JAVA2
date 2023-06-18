package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class MySet <T>{
    private HashMap <T, Object> hashMap = new HashMap<>();
    private static final Object OBJECTVALUE = new Object();
    public MySet(){
    }
    public void addMySet(T key){
        hashMap.put(key, OBJECTVALUE);
    }
    public boolean removeMySet(T key){
        return hashMap.remove(key) == OBJECTVALUE;
    }
    public boolean containsMySet(T key){
        return hashMap.containsKey(key);
    }

    @Override
    public String toString() {
        StringBuilder resSB  = new StringBuilder("[");
        Iterator<T> iter = hashMap.keySet().iterator();

        while (iter.hasNext()){
            resSB.append(iter.next()+",");
        }

        resSB.deleteCharAt(resSB.length()-1);
        resSB.append("]");
        return resSB.toString();
    }
    public Iterator<T> iterator(){
        return hashMap.keySet().iterator();
    }
    public <T> Object readByIndex(int index){
        ArrayList list = new ArrayList<>(hashMap.keySet());
        return list.get(index);
    }
}
