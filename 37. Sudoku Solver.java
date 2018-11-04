/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


A sudoku puzzle...


...and its solution numbers marked in red.

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.
 */

class Solution {
    public void solveSudoku(char[][] board) {
        if(board==null|| board.length==0) return; 
        solver(board);
    }
    
    public boolean solver(char[][] board){
         for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    /*
                    Set<Character> set = new HashSet<>();
                    for(int k=0;k<9; k++) {
                        if(!set.contains(board[i][k])) {
                            set.add(board[i][k]);
                        }
                    }
                    for(int k=0;k<9; k++) {
                        if(!set.contains(board[k][j])) {
                            set.add(board[k][j]);
                        }
                    }
                    */
                     
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if (isValid(board,c, i, j)){
                            board[i][j] = c; //Put c for this cell
                            
                            if(solver(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, char c, int r, int cols){
        //check row
        for(int i=0;i<9; i ++)
            if(board[r][i]==c) return false; 
        
        //check column 
        for(int i=0; i < 9 ; i++)
             if(board[i][cols]==c) return false; 
        //check cube
        int r1=(r/3)*3;
        int c1=(cols/3)*3;
        
        for(int i=r1; i < r1+3; i++)
            for(int j=c1; j<c1+3;j++)
                if(board[i][j]==c) return false; 
        return true;
    }
}