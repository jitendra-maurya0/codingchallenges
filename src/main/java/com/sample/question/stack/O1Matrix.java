package com.sample.question.stack;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

 Example 2:

Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]
 */
public class O1Matrix {


    /*
    A better brute force: Looking over the entire matrix appears wasteful and hence, we can use Breadth First Search(BFS) to limit the search to the nearest 0 found for each 1. As soon as a 0 appears during the BFS, we know that the 0 is nearest, and hence, we move to the next 1.

Think again: But, in this approach, we will only be able to update the distance of one 1 using one BFS, which could in fact, result in slightly higher complexity than the Approach #1 brute force. But hey,this could be optimised if we start the BFS from 0s and thereby, updating the distances of all the 1s in the path.

Algorithm

For our BFS routine, we keep a queue, q to maintain the queue of cells to be examined next.
We start by adding all the cells with 0s to q.
Intially, distance for each 0 cell is 0 and distance for each 1 is INT_MAX, which is updated during the BFS.
Pop the cell from queue, and examine its neighbours. If the new calculated distance for neighbour {i,j} is smaller, we add {i,j} to q and update dist[i][j].
     */
    public int[][] updateMatrix(int[][] matrix) {

        int rows = matrix.length;
        if (rows == 0)
            return matrix;
        int cols = matrix[0].length;
       int[][] dist = new int[rows][cols];
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                    q.add(new Pair<Integer, Integer>(i,j)); //Put all 0s in the queue.
                }

        int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!q.isEmpty()) {
            Pair<Integer, Integer> curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int new_r = curr.getKey() + dir[i][0], new_c = curr.getValue() + dir[i][1];
                if (new_r >= 0 && new_c >= 0 && new_r < rows && new_c < cols) {
                    if (dist[new_r][new_c] > dist[curr.getKey()][curr.getValue()] + 1) {
                        dist[new_r][new_c] = dist[curr.getKey()][curr.getValue()] + 1;
                        q.add(new Pair<Integer, Integer>(new_r,new_c));
                    }
                }
            }
        }
        return dist;

    }
/*
Complexity analysis

Time complexity:O(r⋅c).

Since, the new cells are added to the queue only if their current distance is greater than the calculated distance, cells are not likely to be added multiple times.
Space complexity: O(r⋅c). Additional O(r⋅c) for queue than in Approach #1


 */

    int[][]updateMatrixUsingDfs(int[][]matrix){
        int rows = matrix.length;
        if (rows == 0)
            return matrix;
        int cols = matrix[0].length;
        int[][] dist = new int[rows][cols];

        //First pass: check for left and top
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0)
                    dist[i][j] = 0;
                else {
                    if (i > 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    if (j > 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }

        //Second pass: check for bottom and right
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i < rows - 1)
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                if (j < cols - 1)
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
            }
        }

        return dist;
    }
    public static void main(String[] args) {
        int[][]matrix = {{0,0,0},
            {0,1,0},
            {0,0,0}};
        O1Matrix o1Matrix = new O1Matrix();
        o1Matrix.updateMatrix(matrix);

    }

}
