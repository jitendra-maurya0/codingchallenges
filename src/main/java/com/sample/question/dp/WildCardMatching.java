package com.sample.question.dp;

/**
 * given string with pattern
 * implement regex
 */
public class WildCardMatching {

   boolean isMatch(String s,String p){

       // replace a**b into a*b

       char[]str = s.toCharArray();
       char[]pattern = p.toCharArray();



       boolean isFirst = true;

       int writeCount =0;

       for (int i = 0; i <pattern.length ; i++) {

           if(pattern[i] == '*') {

               if (isFirst) {
                   pattern[writeCount++] = pattern[i];
                   isFirst = false;
               } else {
                   pattern[writeCount++] = pattern[i];
                   isFirst = true;
               }
           }
       }

       boolean T[][] = new boolean[str.length + 1][writeCount + 1];

       if (writeCount > 0 && pattern[0] == '*') {
           T[0][1] = true;
       }
       T[0][0] = true;


       for (int i = 1; i <T.length ; i++) {

           for (int j = 1; j <T[0].length ; j++) {

               if(pattern[j-1] == '?' || str[i-1] ==pattern[j-1] ){
                   T[i][j] = T[i-1][j-1];
               }else if(pattern[j-1] == '*'){
                   T[i][j] = T[i-1][j] || T[i][j-1];

               }
           }
       }
       return T[str.length][writeCount];
   }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a**b";
        WildCardMatching matching = new WildCardMatching();
        System.out.println(matching.isMatch(s,p));

    }
}
