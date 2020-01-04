package com.sample.question;

public class ReverseNumber {

    public static int reverse(int x) {

      int rev =0;

      while (x != 0){
          int pop = x%10;
          x = x/10;
          if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
          if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

           rev = rev*10+pop;
      }
        return  rev;


    }

    public static boolean isPolindrome(int x){
        String s = String.valueOf(x);
        int end = s.length()-1;
        for(int start=0;start <= end/2;){

            if(s.charAt(start) == s.charAt(end)){
                start ++;
                end --;
            }else{
                return false;
            }

        }

        return true;

    }

    public static void main(String[] args) {
        int x = 1000030001;

        System.out.println(isPolindrome(x));
    }
}
