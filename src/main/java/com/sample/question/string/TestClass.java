package com.sample.question.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String s = br.readLine().trim();

        String out_ = Palindromic_Subsequence(s);
        wr.println(out_);

        wr.close();
        br.close();
    }

    static String Palindromic_Subsequence(String s) {
        String res = "";
        char mx = s.charAt(0);

        for (int i = 1; i < s.length(); i++)
            mx = (char)Math.min((int)mx,
                    (int)s.charAt(i));

        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == mx)
                res += s.charAt(i);

        return res;

    }
}