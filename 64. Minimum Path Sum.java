/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1¡ú3¡ú1¡ú1¡ú1 minimizes the sum.
*/
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int row = 0; row < m; row++){
            for (int col = 0; col < n; col++){
                if (row == 0 && col != 0){
                    dp[row][col] = dp[row][col-1]+grid[row][col];
                }
                else if (row != 0 && col == 0){
                    dp[row][col] = dp[row-1][col]+grid[row][col];
                }
                else if (row == 0 && col == 0){
                    continue;
                } else {
                    dp[row][col] = Math.min(dp[row-1][col],dp[row][col-1])+grid[row][col];
                }
            }
        }
        return dp[m-1][n-1];   
    }
}