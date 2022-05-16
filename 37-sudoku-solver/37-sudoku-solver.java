class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
        return;
    }
    
    // board.length == 9
    private boolean backtrack(char[][] board, int row, int col) {
        // row to end, we found a solution
        if (row >= 9) {
            return true;
        }
        // col to end, we go next level (row)
        if (col >= 9) {
            return backtrack(board, row + 1, 0);
        }
        
        // skip to next position
        if (board[row][col] != '.') {
            return backtrack(board, row, col + 1);
        }
        

        for (char ch = '1'; ch <= '9'; ch++) {
            
            if (isValid(board, row, col, ch)) {
                board[row][col] = ch;
                if (backtrack(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        
        return false;
    }
    
    private boolean isValid(char[][] board, int i, int j, char c) {
        // check row and column
        for (int temp = 0; temp < 9; temp++) {
            if (board[i][temp] == c) {
                return false;
            }
            if (board[temp][j] == c) {
                return false;
            }
            
            // check 3x3 square
            if (board[(i/3)*3 + temp / 3][(j/3)*3 + temp % 3] == c) {
                return false;
            }
        }

        
        return true;
    }
}