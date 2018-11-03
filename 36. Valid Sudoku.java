/*
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.
 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // check3x3 sub-boxes
                Set<Character> digits = new HashSet<>();
                if (i%3 == 0 && j%3 == 0) {
                    for (int m = i; m < i + 3; m++){
                        for (int n = j; n < j + 3; n++){
                            if (board[m][n] == '.'){
                                continue;
                            } else {
                                if (digits.contains(board[m][n])){
                                    return false;
                                }
                                digits.add(board[m][n]);
                            }
                        }
                    }
                }
                digits.clear();
                //check every column
                if (i == 0){
                    for (int m = 0; m < board.length; m++){
                        if (board[m][j] == '.'){
                            continue;
                        } else {
                            if (digits.contains(board[m][j])){
                                return false;
                            }
                            digits.add(board[m][j]);
                        }
                    }
                }
                digits.clear();
                if (j == 0) {
                    //check every row;
                    for (int m = 0; m < board[i].length; m++){
                        if (board[i][m] == '.'){
                            continue;
                        } else {
                            if (digits.contains(board[i][m])){
                                return false;
                            }
                            digits.add(board[i][m]);
                        }
                    }
                }
            }
        }
        return true;
    }
}