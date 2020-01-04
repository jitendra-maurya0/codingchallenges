package com.sample.question.array;

public class LongestPathInGivenMatrix {

    static int maxPath(int[][]mat){

        int result = 1;
        int[][]dp = new int[mat.length][mat.length];

        for (int i = 0; i <mat.length ; i++) {

            for (int j = 0; j < mat.length; j++) {

                dp[i][j] =-1;
            }
        }



        for (int i = 0; i <mat.length ; i++) {
            for (int j = 0; j <mat.length ; j++) {
                if(dp[i][j] == -1){
                    result = findMaxForACell(mat,i,j,dp);
                    result = Math.max(result,dp[i][j]);
                }
            }
        }

         return  result;



    }

    static int findMaxForACell(int[][]mat,int i,int j,int[][]dp){

        int n = mat.length;
        if(i <0 || i >=n || j<0 ||j>=n){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }


        if(i > 0 && ((mat[i][j]+1) == mat[i-1][j])){
           return dp[i][j] = 1+findMaxForACell(mat,i-1,j,dp);
        }

        if( i< n-1 &&((mat[i][j]+1) == mat[i+1][j])){
            return dp[i][j] = 1+findMaxForACell(mat,i+1,j,dp);
        }

        if(j > 0 && ((mat[i][j]+1) ==mat[i][j-1])){
           return dp[i][j] = 1+ findMaxForACell(mat,i,j-1,dp);
        }

        if(j < n-1 && ((mat[i][j]+1) == mat[i][j+1])){
           return dp[i][j] = 1 +findMaxForACell(mat,i,j+1,dp);
        }

        return dp[i][i] =1;

    }


    public static void main(String[] args) {

        int[][]mat = {{1,2,9},{5,3,8},{4,6,7}};

        System.out.println(maxPath(mat));

    }
}
