class Solution {
    public int countServers(int[][] grid) {
        // time O(MN*(M+N)), 对一共mn个点，横竖遍历m + n
        // similar to number of islands, but count island size
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int cur = dfs(visited, grid, i, j);
                    res += cur > 1 ? cur : 0;
                }
            }
        }
        
        return res;
    }
    
    private int dfs(boolean[][] visited, int[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 1;
        visited[x][y] = true;
        
        for (int i = 0; i < m; i++) {
            if (grid[i][y] == 1 && !visited[i][y]) {
                res += dfs(visited, grid, i, y);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (grid[x][i] == 1 && !visited[x][i]) {
                res += dfs(visited, grid, x, i);
            }
        }
        
        return res;
    }
}