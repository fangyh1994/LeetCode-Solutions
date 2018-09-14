/*
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
class Solution {
    public int[][] generateMatrix(int n) {
        int [][] result = new int [n][n];
        int i = 1;
        int top = 0;
        int bot = n-1;
        int left = 0;
        int right = n-1;
        while (i <= n*n){
            for (int col = left; col <= right; col++){
                result [top][col] = i;
                i++;
            }
            top++;
            for (int row = top; row <= bot; row++){
                result [row][right] = i;
                i++;
            }
            right--;
            for (int col = right; col >= left; col--){
                result[bot][col] = i;
                i++;
            }
            bot--;
            for (int row = bot; row >=top; row--){
                result[row][left] = i;
                i++;
            }
            left++;
        }
        return result;
    }
}