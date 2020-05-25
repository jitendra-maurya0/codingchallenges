package com.sample.question.array;

import java.util.ArrayList;
import java.util.List;

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
 */
public class SpiralMatrix {

    List<Integer>spiralOrder(int[][]mat){
        List<Integer> ans = new ArrayList();
        if (mat.length == 0) return ans;
        int R = mat.length, C = mat[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r=0,c=0,d=0;
        for(int i=0;i<R*C;i++){
            ans.add(mat[r][c]);
            seen[r][c] = true;
            int cr = r+dr[d];
            int cc = c+dc[d];
            if(cr>=0  && cr < R && cc >=0 &&  cc< C && !seen[cr][cc]){
                r = cr;
                c = cc;
            }else{
                d = (d+1)%4;
                r += dr[d];
                c += dc[d];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][]mat = {{1, 2, 3 },
        {4, 5, 6 },
        { 7, 8, 9 }};

        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.println(spiralMatrix.spiralOrder(mat));

    }

}
