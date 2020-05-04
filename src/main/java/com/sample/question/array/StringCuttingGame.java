package com.sample.question.array;

public class StringCuttingGame {

    public static void main(String[] args) {
        String s = "AbcDef";
        System.out.println(turn(s,1,2));
    }
    static int turn(String s,int input1,int input2){
        int count = 0;
        String str = s;
        do{
            String h = s.substring(s.length()-input1);

            s = h+s.substring(0,s.length()-input1);
            String p = s.substring(s.length()-input2);
            s = p+s.substring(0,s.length()-input2);
            count++;
        }while (!str.equals(s));
        return count;
    }
}
