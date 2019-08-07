/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
*/
class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                if (x == 0 || y == 0 || x == row - 1 || y == col - 1) {
                    if (board[x][y] == 'O') {
                        dfs(board, x, y);
                    }
                }
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == '*') {
                    board[i][j] ='O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }
    
    public void dfs(char[][] board, int x, int y) {
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
        if(board[x][y] == 'X' || board[x][y] == '*') return;
        board[x][y] = '*';
        if(x + 1 < board.length)
            dfs(board, x + 1, y);
        if(x - 1 > 0)
            dfs(board, x - 1, y);
        if(y + 1 < board[0].length)
            dfs(board, x, y + 1);
        if(y - 1 > 0)
            dfs(board, x, y - 1);
    }
}