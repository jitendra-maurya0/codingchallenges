package com.sample.test;

public class RegularExpression {

    boolean isMatch(String text,String pattern){

        //base case:
        if(pattern.isEmpty()) return text.isEmpty();

        boolean first_match = (!text.isEmpty() && (text.charAt(0) == pattern.charAt(0))) || (pattern.charAt(0) == '.');

        if(pattern.length() >= 2 && pattern.charAt(1) =='*'){
            return isMatch(text,pattern.substring(2)) || (first_match && isMatch(text.substring(1),pattern));
        }else{
           return first_match && isMatch(text.substring(1), pattern.substring(1));
        }

    }

    boolean isMatchDP(String s,String p){
        boolean dp [][] = new boolean [s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        // Deals with things like a* or a*b*.
        for(int i = 1; i < dp[0].length; i++){
            if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-2];
                    if(p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1)){
                        dp[i][j] = dp[i][j] | dp[i-1][j];
                    }
                }else{
                    dp[i][j] = false;
                }
            }

        }
        return dp[s.length()][p.length()];
    }


    public static void main(String[] args) {
        RegularExpression re = new RegularExpression();
        String text = "aa";
        String pattern = "a*";
        System.out.println(re.isMatchDP(text,pattern));
    }
}
