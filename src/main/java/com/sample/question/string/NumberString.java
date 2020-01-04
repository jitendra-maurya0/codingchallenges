package com.sample.question.string;

import java.io.IOException;

public class NumberString {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter wr = new PrintWriter(System.out);
//        int T = Integer.parseInt(br.readLine().trim());
//        for (int t_i = 0; t_i < T; t_i++) {
//            String[] arr_query1 = br.readLine().trim().split(" ");
//            int n = Integer.parseInt(arr_query1[0]);
//            int k = Integer.parseInt(arr_query1[0]);
//
//            wr.println(out_);
//        }
//
//        wr.close();
//        br.close();

        String out_ = solve(5, 42);
        System.out.println(out_);
    }

    static String solve(int k, int n) {
        char[] a = new char[n];
        // Initially fill the array with character 'a'
        for(int i=0;i<n;i++){
            a[i] = 'a';
        }
        int a_count = n;
        int tot_count = k;
        int x = tot_count - a_count;
        for(int i=n-1;i>=0; i--){
            if(x> 26){
                a[i] = 'z';
                x = (x-26)+1;
            }
            else if(x == 26){
                a[i] = (char) (a[i] + 25);
                x = x - 25;
            }
            else if(x > 0){
                a[i] = (char) (a[i] + x);
                x = 0;
            }
            if(x == 0)
                break;
        }
        String op= String.valueOf(a);
        System.out.println(op);
return op;

    }
}
