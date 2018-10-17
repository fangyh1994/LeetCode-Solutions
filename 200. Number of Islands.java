/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/

class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        if (grid.length == 0){
            return 0;
        }
        if (grid[0].length == 0){
            return 0;
        }
        char[][] visited = new char[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[0].length; col++){
                if (visited[row][col] != '1' && grid[row][col] == '1'){
                    result++;
                    dfs(grid, visited, row, col);
                }
            }
        }
        return result;
    }
    
    public void dfs(char[][] grid, char[][] visited, int row, int col){
        int maxRow = grid.length - 1;
        int maxCol = grid[0].length - 1;
        if (row > 0 && visited[row-1][col] != '1' && grid[row-1][col] == '1') {
            visited[row-1][col] = '1';
            dfs (grid, visited, row-1, col);
        }
        if (row < maxRow && visited[row + 1][col] != '1' && grid[row+1][col] == '1'){
            visited[row+1][col] = '1';
            dfs (grid, visited, row+1, col);
        }
        if (col > 0 && visited[row][col-1] != '1' && grid[row][col-1] == '1') {
            visited[row][col-1] = '1';
            dfs (grid, visited, row, col-1);
        }
        if (col < maxCol && visited[row][col+1] != '1' && grid[row][col+1] == '1'){
            visited[row][col+1] = '1';
            dfs (grid, visited, row, col+1);
        }
    }
}