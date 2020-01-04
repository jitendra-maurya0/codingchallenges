package com.sample.test.oops;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Test {
    static void deleteElements(int arr[], int n,int k) {
        // Create a stack and push arr[0]
        Stack<Integer> s = new Stack<>();
        s.push(arr[0]);

        int count = 0;

        // traversing a loop from i = 1 to n
        for (int i = 1; i < n; i++) {

            // condition for deleting an element
            while (!s.empty() && s.peek() < arr[i]
                    && count < k) {
                s.pop();
                count++;
            }

            s.push(arr[i]);
        }

        // Putting elements of stack in a vector
        // from end to begin.
        int m = s.size();
        Integer[] v = new Integer[m]; // Size of vector is m
        while (!s.empty()) {

            // push element from stack to vector v
            v[--m] = s.peek();
            s.pop();
        }

        // printing result
        for (Integer x : v) {
            System.out.print(x + " ");
        }

        System.out.println(" ");
    }

    public static String findFirstRepeatedWord(String str) {
        String word[] = str.split(" ");

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String string : word) {
            if (map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
            } else {
                map.put(string, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1)
                return entry.getKey();
        }
        return "Not repeated";
    }


}

