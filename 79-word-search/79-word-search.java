class Solution {
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, visited, i, j, word, new StringBuilder())) {
                return true;        
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, StringBuilder path) {
        if (path.toString().equals(word)) {
            return true;
        } else if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return false;
        } else if (!word.contains(path.toString())) {
            return false;
        }
        
        visited[i][j] = true;
        path.append(board[i][j]);
        boolean up = dfs(board, visited, i - 1, j, word, path);
        boolean down = dfs(board, visited, i + 1, j, word, path);
        boolean left = dfs(board, visited, i, j - 1, word, path);
        boolean right = dfs(board, visited, i, j + 1, word, path);
        if (up || down || left || right) return true;
        visited[i][j] = false;
        path.setLength(Math.max(0, path.length() - 1));
        
        return false;
    }
}