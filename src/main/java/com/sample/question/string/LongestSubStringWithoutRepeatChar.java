package com.sample.question.string;

import java.util.HashMap;

public class LongestSubStringWithoutRepeatChar {

    static int findLongestSubStringWithoutRepeatingChar(String src){
        if(src.length() ==0 || src==null) return 0;
        char[]arr = src.toCharArray();
        int max =0;
        int lastDupIndex=-1;
        HashMap<Character,Integer>map = new HashMap<>();
        for (int i = 0; i <arr.length ; i++) {
            Integer lastIndex = map.get(arr[i]);
            if(lastIndex != null && lastDupIndex < lastIndex){

                lastDupIndex = lastIndex;
            }
            max = Math.max(max,i-lastDupIndex);
            map.put(arr[i],i);

        }
        return max;

    }

    public static void main(String[] args) {
        String s =  "abcabcbb";
        System.out.println(findLongestSubStringWithoutRepeatingChar(s));
    }
}
