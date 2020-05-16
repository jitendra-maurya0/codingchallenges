package com.sample.question.array;

import java.util.*;
import java.util.stream.Collectors;

public class LongestConsecutiveStreaks {

    static int longestConsecutive(int[] arr) {
        List<List<Integer>>list = new ArrayList<>();

        int prev =0,next =1;
        List<Integer> l = new ArrayList<>();
        while (next <arr.length){

            if(arr[next-1] <= arr[next]){
                next++;
            }else{
                add(arr,prev,next,list);
                prev = next;
                next++;
            }

        }
         return maxProfit(list);



    }
    static int maxProfit(List<List<Integer>>list){
        List<List<Integer>> filterdList = list.stream().filter(l1->l1.size() >1).collect(Collectors.toList());
        int max = Integer.MIN_VALUE;
        for (List<Integer>l:filterdList){
              int profit = Math.abs(l.get(l.size()-1)-l.get(0));
                      if(profit >max){
                          max = profit;
                      }
        }
        return max;
    }
    private static void add(int[]arr,int s,int l,List<List<Integer>> list){
        ArrayList<Integer>list1 = new ArrayList<>();
        while (s <l){
            list1.add(arr[s]);
            s++;
        }
        list.add(list1);
    }

    public static void main(String[] args) {
       // int[]arr = {3, 6, 36, 32 ,32 ,121 ,66 ,24 ,26 ,371 ,661 ,6 ,4 ,8};

        Scanner sc = new Scanner(System.in);
        List<Integer> l = new ArrayList<>();
//        for (int i = 0; i <arr.length ; i++) {
//            l.add(arr[i]);
//        }

        while (sc.hasNext()){

            int n = sc.nextInt();
            if(n >0 ){
                l.add(n);
            }else{
                break;
            }

        }
        int[]arr = new int[l.size()];
        for (int i = 0,j=0; i <l.size() ; i++) {
            arr[j] = l.get(i);
            j++;
        }

        System.out.println(longestConsecutive(arr));
    }
}
