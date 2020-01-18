package com.sample.question.annonymus;

public class BooleanMatrix {


    static void printMatrix(int[][]mat){

        for(int i=0; i<mat.length;i++){


            for(int j=0; j<mat[0].length;j++) {

                System.out.print(mat[i][j]);
        }

            System.out.println();
        }
    }

    //modify
    static void modify(int[][]mat){
        boolean rowFlag = false;
        boolean colFlag = false;

        for (int i = 0; i <mat.length ; i++) {
            for (int j = 0; j <mat[0].length ; j++) {

                if(i ==0 && mat[i][j] ==1)
                    rowFlag = true;

                if(j ==0 && mat[i][j] == 1)
                    colFlag = true;


                if (mat[i][j] == 1){
                    mat[i][0] = 1;
                    mat[0][j] = 1;


                }
            }
        }

        // move to next row

        for (int i = 1; i <mat.length ; i++) {

            for (int j = 1; j <mat[0].length ; j++) {

                if(mat[0][j] == 1 || mat[i][0] == 1){
                    mat[i][j] = 1;
                }
            }
        }

        if (rowFlag){

            for (int i = 0; i <mat[0].length ; i++) {

                mat[0][i] = 1;

            }
        }
 if (colFlag){

            for (int i = 0; i <mat.length ; i++) {

                mat[i][0] = 1;

            }
        }


    }


    public static void main(String[] args) {


        int mat[][] = {{1, 0, 0, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 0}};

        System.out.println("Input Matrix :");
        printMatrix(mat);

        modify(mat);

        System.out.println("Matrix After Modification :");
        printMatrix(mat);

    }
}
