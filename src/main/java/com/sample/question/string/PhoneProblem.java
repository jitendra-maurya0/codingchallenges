package com.sample.question.string;

import java.util.ArrayList;
import java.util.List;

/**
 * given number  print all combination of string formed by that number
 * as display on phone number
 */
public class PhoneProblem {
     List<String> res = new ArrayList<>();
     String[]dict = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
     void solution(String digits){

        combination(digits,0,"");
        System.out.println(res);
    }

    private void   combination(String digits, int i, String s) {
        if(i == digits.length()){
            if(!s.isEmpty()){
                res.add(s);
            }
            return ;
        }
        String k = dict[digits.charAt(i)-'0'];
        for (Character c:k.toCharArray()) {
            combination(digits,i+1,s+c);
        }
    }

    public static void main(String[] args) {
        String input = "236";
       PhoneProblem phoneProblem =  new PhoneProblem();
        phoneProblem.solution(input);
    }
}
