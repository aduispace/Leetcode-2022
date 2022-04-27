class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] arr : board) {
            Arrays.fill(arr, '.');
        }
        backtrack(board, 0, n, n);
        
        return res;
    }
    
    private void backtrack(char[][] board, int row, int n, int leftQueen) {
        if (leftQueen == 0) {
            // found a solution
            List<String> curRes = new ArrayList<>();
            for (char[] arr : board) {
                curRes.add(String.valueOf(arr));
            }
            res.add(curRes);
            return;
        } else if (row == n) {
            // not found
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (isValid(board, row, i)) {
                board[row][i] = 'Q';
                backtrack(board, row + 1, n, leftQueen - 1);
                // backtrack and revoke the selection
                board[row][i] = '.';
            }
        }
        
        return;
    }
    
    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        
        for (int i = row; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        
        for (int i = col; i >= 0; i--) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        return true;
    }
}