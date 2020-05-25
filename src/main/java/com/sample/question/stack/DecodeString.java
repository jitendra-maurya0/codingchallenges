package com.sample.question.stack;
/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {
    public String decodeString(String s) {

        java.util.Stack<Integer> st=new  java.util.Stack<>();

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='[')
                st.push(i);
            else if(s.charAt(i)==']')
            {
                int k=st.pop();
                String temp=s.substring(k+1,i);
                int j;
                for( j=k-1;j>=0;j--)
                {
                    if(Character.isDigit(s.charAt(j)))
                        continue;
                    else break;
                }

                int num=Integer.parseInt(s.substring(j+1,k));
                String r=temp;
                while(num-- > 1)
                    r=r+temp;

                s=s.substring(0,j+1)+r+s.substring(i+1);
                i=j+r.length();

            }

        }

        return s;

    }
}

