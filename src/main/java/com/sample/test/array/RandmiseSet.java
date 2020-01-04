package com.sample.test.array;

import java.util.*;

public class RandmiseSet {
    List<Integer> list = new ArrayList<>();
    Map<Integer,Integer> map = new HashMap<>();

    public boolean add(int val){
        if(map.containsKey(val)) return false;

        map.put(val,list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val){

        if(!map.containsKey(val)) return false;
            int index = map.get(val);
            int last = list.get(list.size()-1);
            list.set(index,last);
            list.remove(list.size()-1);
            map.put(last,index);
            map.remove(val);
            return true;

    }

    public int getRandom(){
        Random random = new Random();
      return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandmiseSet randmiseSet = new RandmiseSet();

    }

}
