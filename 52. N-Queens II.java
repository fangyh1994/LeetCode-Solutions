/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:

Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */
class Solution {
    /*private int ans = 0;
    public int totalNQueens(int n) {
        int queenNum = 0;
        int index = 0;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(board, 0, 0);
        return ans;
    }
    
    private void dfs(char[][] board, int index, int queenNum) {
        if (queenNum == board.length) {
            ans++;
            return;
        }
        
        for (int i = index; i < board.length * board.length; i++) {
            board[i / board.length][i % (board.length)] = 'Q';
            //System.out.print(i / board.length);
            //System.out.print(i % (board.length));
            //System.out.println();
            if (validate(board, i/board.length, i % (board.length))) {
                dfs(board, i + 1, queenNum + 1);
                
            }
            board[i / board.length][i % (board.length)] = '.';
            
        }
        
    }
    
    private boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                // if (i == x && j == y) {
                //     continue;
                // }
                if ((x!=i || y!=j) && (x == i || y == j || (x-y) == (i-j) || (x-i) == (j-y) )) { 
                    return false;
                }             
            }
        }
        return true;
    }
    */
    
    /////easy and brief solution
    int ans = 0;
    public int totalNQueens(int n) {
        int queenNum = 0;
        int[] pos = new int[n];
        dfs(pos, 0);
        return ans;
    }
    
    private void dfs(int[] pos, int queenNum) {
        if (queenNum == pos.length) {
            ans++;
            return;
        }
        for (int i = 0; i < pos.length; i++) {
            pos[queenNum] = i;
            if (validate(pos, queenNum)) {
                dfs(pos, queenNum+1);
            }
        }
        return;
    }
    
    private boolean validate (int[] pos, int queenNum) {
        for (int i = 0; i < queenNum; i++) {
            if (pos[i] == pos[queenNum] || Math.abs(pos[i] - pos[queenNum]) == queenNum - i) {
                return false;
            }
        }
        return true;
    }
    
}