/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
*/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res);
        return res;
    }
    
    private void dfs(char[][] board, int index, List<List<String>> res) {
        /*
        index: the index of Queen
        board: temp backtracking 2d array
        res: output format
        */
        if (index == board.length) {
            res.add(construct(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (validate(board, i, index)) {
                //i is rowindex, index is colindex
                //construct a puzzle row by row
                board[i][index] = 'Q';
                dfs(board, index + 1, res);
                board[i][index] = '.';
            }
        }
    }
    private boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                //j < y instead of j < board.length because the
                if (i == x && j == y) {
                    continue;
                }
                if (board[i][j] == 'Q' && (x - y == i - j || x - i == j - y || x == i) ) {
                    return false;
                }
            }
        }
                   
        return true;
    }
    
    //convert format from char[][] to List<String>
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}