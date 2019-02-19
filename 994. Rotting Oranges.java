/*
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

Example 1:
Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        boolean hasFreshOrange = false;
        for (int i = 0; i < grid.length; i++) {
            if (hasFreshOrange == true) {
                break;
            }
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    hasFreshOrange = true;
                    break;
                }
            }
        }
        if (hasFreshOrange == false) {
            return 0;
        }
        int step = 0;
        boolean hasChange = true;
        while (hasChange == true) {
            step++;
            hasChange = false;
            int[][] temp = new int[grid.length][grid[0].length];
            /*copy grid to temp*/
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    temp[i][j] = grid[i][j]; 
                }
            }
            
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1 && hasRottenAdjacent(temp, i, j)) {
                        grid[i][j] = 2;
                        hasChange = true;
                    } 
                }
            }
        }
        
        hasFreshOrange = false;
        for (int i = 0; i < grid.length; i++) {
            if (hasFreshOrange == true) {
                break;
            }
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    hasFreshOrange = true;
                    break;
                }
            }
        }
        if (hasFreshOrange) {
            return -1;
        }
        
        return step-1;
    }

    private boolean hasRottenAdjacent(int[][] temp, int i, int j) {
        int row = temp.length;
        int col = temp[0].length;
        
        if (i < row - 1) {
            if (temp[i+1][j] == 2) {
                return true;
            }
        }
        if (i > 0) {
            if (temp[i-1][j] == 2) {
                return true;
            }
        }
        if (j < col - 1) {
            if (temp[i][j+1] == 2) {
                return true;
            }
        }
        if (j > 0) {
            if (temp[i][j-1] == 2) {
                return true;
            }
        }
        return false;
    }
}