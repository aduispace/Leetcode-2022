class Solution {
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, visited, i, j, word, 0)) {
                    return true;        
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        } else if (index == word.length() - 1) {
            return true;
        }
        
        visited[i][j] = true;
        boolean up = dfs(board, visited, i - 1, j, word, index + 1);
        boolean down = dfs(board, visited, i + 1, j, word, index + 1);
        boolean left = dfs(board, visited, i, j - 1, word, index + 1);
        boolean right = dfs(board, visited, i, j + 1, word, index + 1);
        if (up || down || left || right) return true;
        visited[i][j] = false;
        
        return false;
    }
}