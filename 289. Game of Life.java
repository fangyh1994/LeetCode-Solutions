/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
 */
class Solution {
    public void gameOfLife(int[][] board) {
        //coding 0: this state 0, next state 0
        //coding 1: this state 1, next state 1
        //coding 2: this state 0, next state 1
        //coding 3: this state 1, next state 0
        if (board.length == 0){
            return;
        }
        if (board[0].length == 0){
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                int neighbors = calculate (board, i, j);
                if (neighbors < 2 && board[i][j] == 1){
                    board[i][j] = 3;
                } else if (neighbors >= 2 && neighbors <= 3 && board[i][j] == 1){
                    board[i][j] = 1;
                } else if (neighbors > 3 && board[i][j] == 1) {
                    board[i][j] = 3;
                } else if (neighbors == 3 && board[i][j] == 0) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (board[i][j] == 3){
                    board[i][j] = 0;
                }
                if (board[i][j] == 2){
                    board[i][j] = 1;
                } 
            }
        }
    }

    public static int calculate (int[][] board, int i, int j){
        int res = 0;
        int row = board.length;
        int col = board[0].length;
        if (i > 0) {
            if (board[i-1][j] == 1 || board[i-1][j] == 3){res++;}
            if (j > 0) {
                if (board[i-1][j-1] == 1 || board[i-1][j-1] == 3){res++;}
            }
            if (j < col - 1) {
                if (board[i-1][j+1] == 1 || board[i-1][j+1] == 3){res++;}
            }
        }
        if (i < row - 1){
            if (board[i+1][j] == 1 || board[i+1][j] == 3){res++;}
            if (j > 0) {
                if (board[i+1][j-1] == 1 || board[i+1][j-1] == 3){res++;}
            }
            if (j < col - 1) {
                if (board[i+1][j+1] == 1 || board[i+1][j+1] == 3){res++;}
            }
        }

        if (j > 0) {
            if (board[i][j-1] == 1 || board[i][j-1] == 3){res++;}
        }
        if (j < col - 1){
            if (board[i][j+1] == 1 || board[i][j+1] == 3){res++;}
        }
        return res;
    }
}