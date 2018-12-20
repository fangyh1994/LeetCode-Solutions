/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void rotate(int[][] matrix) {
        int d = matrix.length; //length
        if (d == 0 || d == 1) {
            return;
            //return matrix;
        }
        for (int i = 0; i < d/2; i++) {
            for (int j = i; j < d-1-i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[d-1-j][i];
                matrix[d-1-j][i] = matrix[d-i-1][d-1-j];
                matrix[d-i-1][d-1-j] = matrix[j][d-i-1];
                matrix[j][d-i-1] = temp;
                
                //i,j
                //j, d-i-1
                //d-i-1, d-1-j
                //d-1-j, i
            }
        }
        //return matrix;
    }
}