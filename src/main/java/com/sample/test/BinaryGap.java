package com.sample.test;

public class BinaryGap {

    static int longestSequence(int n){
        String binString = Integer.toBinaryString(n);
        int start =0;
        int end =0;
        int max =0;
        for(int i= 0;i<binString.length()-1;i++){
            if(binString.charAt(i) == '1'){
                int count =0;
                start = i;
                end = start+1;
                //count zero
                while (binString.length() != end && binString.charAt(end) == '0'){
                    count++;
                    end++;
                }
               // start = end;

                if(count > max && binString.length() != end && binString.charAt(end) == '1'){
                    max = count;


                }
            }

            i = end-1;
        }
        return max;
    }



    public static void main(String[] args) {
      //  System.out.println(longestSequence(32 ));
        System.out.println(longestSequence(1041  ));
    }
}
