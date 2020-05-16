package com.sample.question.array;

import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 */
public class ConvertStringIntoZigzag {

    public static String convertZigZag(String s,int noOfRows){
        if(noOfRows == 1) return s;

        List<StringBuilder> row = new ArrayList<>();
        for(int i=0;i<Math.min(noOfRows,s.length());i++){
            row.add(new StringBuilder());
        }
        int currentRow = 0;
        boolean goingDown = false;
        for (char c:s.toCharArray()) {
            row.get(currentRow).append(c);
            if(currentRow == 0 || currentRow == noOfRows-1) goingDown = !goingDown;
            currentRow += goingDown?1:-1;

        }
        StringBuilder rest = new StringBuilder();
        for(StringBuilder sb: row){
            rest.append(sb);
        }
        return rest.toString();

    }
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convertZigZag(s,3));
    }
}
