package com.sample.test.array;

/**
 * given matrix of char search a word exist or not in matrix via moving ups down and left right
 */
public class WordSearch {

    boolean isExist(char[][]board,String word){
        int row = board.length;
        int col = board[0].length;

        boolean result = false;
        for (int i = 0; i <row ; i++) {

            for (int j = 0; j <col ; j++) {
               if( dfs(board,word,i,j,0)){
                   result = true;
               }
            }
        }
        return result;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int start) {

          int m = board.length;
          int n = board[0].length;
        if(row <0 ||col <0 || row > m || col > n){
            return false;
        }
        if(board[row][col] == word.charAt(start)){
            char temp = board[row][col];
            board[row][col] = '#';
            if(start == word.length()-1) return true;
            else{
                if(dfs(board,word,row+1,col,start+1)
                        ||dfs(board,word,row,col+1,start+1)
                        ||dfs(board,word,row-1,col,start+1)
                        || dfs(board,word,row,col-1,start+1))
                    return true;
            }
            board[row][col] = temp;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] dict = {{'a'},{'b'}};
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.isExist(dict,"c"));
    }


}
