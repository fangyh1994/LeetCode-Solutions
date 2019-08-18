/*
Given an N x N grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized and return the distance.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.

If no land or water exists in the grid, return -1.
*/
class Solution {
    public int maxDistance(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        int max = row * col;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    continue;
                } else {
                    grid[i][j] = max;
                }
                if (i == 0 && j == 0) { 
                    continue; 
                } else if (j == 0) {
                    grid[i][j] = Math.min(grid[i][j], grid[i-1][j] + 1);
                } else if (i == 0) {
                    grid[i][j] = Math.min(grid[i][j], grid[i][j-1] + 1);
                } else {
                    grid[i][j] = Math.min(grid[i][j], Math.min(grid[i-1][j], grid[i][j-1]) + 1);
                }
            }
        }

        max = grid[row-1][col-1];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (grid[i][j] == 0 || (i == row - 1 && j == col - 1)) {
                    continue;
                } else if (i == row - 1) {
                    grid[i][j] = Math.min(grid[i][j], grid[i][j+1] + 1);
                } else if (j == col - 1) {
                    grid[i][j] = Math.min(grid[i][j], grid[i+1][j] + 1);                    
                } else {
                    grid[i][j] = Math.min(grid[i][j], Math.min(grid[i+1][j], grid[i][j+1]) + 1);
                }
                max = Math.max(max, grid[i][j]);
            }
        }

        if (max == 0 || max == row * col) max = -1;
        return max;
    }
}