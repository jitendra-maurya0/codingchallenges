package com.sample.question;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Program  {



public static void main(String[]args){

//     String s = "pwwkew";
//    System.out.println(lengthOfLongestSubstringUsingSlidingWindowOpt(s));

}




//brute force checking one by one

    public static int lengthOfLongestSubstring(String s) {

              int ans =0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <=s.length() ; j++) {
                if(isUniqueChar(s,i,j)) ans = Math.max(ans,j-i);

            }
        }

        return ans;

    }

    public static int lengthOfLongestSubstringUsingSlidingWindow(String s) {

        int ans =0;
         Set<Character>set = new HashSet<>();
         int n = s.length();
         int i=0,j=0;
         while (i< n && j < n){

             if(!set.contains(s.charAt(j))){
                 set.add(s.charAt(j++));
                 ans = Math.max(ans,j-i);
             }else{
                 set.remove(s.charAt(i++));
             }
         }



        return ans;

    }

    public static  int lengthOfLongestSubstringUsingSlidingWindowOpt(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    static boolean isUniqueChar(String s,int startIndex,int endIndex){
        Set<Character>set = new HashSet<>();

        for (int i = startIndex; i <endIndex ; i++) {
            if(set.contains(s.charAt(i))) return false;
            set.add(s.charAt(i));
        }

        return true;

    }


}

