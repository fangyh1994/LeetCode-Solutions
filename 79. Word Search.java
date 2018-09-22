/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/
class Solution {
    static boolean visited[][];
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == word.charAt(0)){
                    if ( isExist(i,j,board,word.substring(1,word.length())) ){
                        return true;
                    };
                }
            } 
        }
        return false;
    }
    public boolean isExist(int i, int j, char[][] board, String word){
        visited[i][j] = true;
        if (word.length() == 0){
            return true;
        }
        boolean top = false;
        boolean bot = false;
        boolean left = false;
        boolean right = false;
        if (i < board.length-1 && board[i+1][j] == word.charAt(0) && (visited[i+1][j] == false)) {
            bot = isExist(i+1,j,board, word.substring(1,word.length()));
        }
        if (i > 0 && board[i-1][j] == word.charAt(0) && (visited[i-1][j] == false)){
            top = isExist(i-1,j,board, word.substring(1,word.length()));
        }
        if (j < board[0].length-1 && board[i][j+1] == word.charAt(0) && (visited[i][j+1] == false)){
            right = isExist(i,j+1,board, word.substring(1,word.length()));
        }
        if (j > 0 && board[i][j-1] == word.charAt(0) && (visited[i][j-1] == false)){
            left = isExist(i,j-1,board, word.substring(1,word.length()));
        }
        if (top||bot||left||right){
            return true;
        } else {
            visited[i][j] = false;
            return false;
        }
    }
}