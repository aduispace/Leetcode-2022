class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        
        Queue<int[]> q = new LinkedList<>(); // queue to process the index
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    q.offer(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0];
                        int y = cur[1];
                        visited[x][y] = true;
                        
                        // BFS to four directions
                        if (x - 1 >= 0 && grid[x - 1][y] == '1' && !visited[x - 1][y]) {
                            visited[x-1][y] = true;
                            q.offer(new int[]{x - 1, y});
                        }
                        if (x + 1 <= m - 1 && grid[x + 1][y] == '1' && !visited[x + 1][y]) {
                            visited[x+1][y] = true;
                            q.offer(new int[]{x + 1, y});
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1' && !visited[x][y - 1]) {
                            visited[x][y - 1] = true;
                            q.offer(new int[]{x, y - 1});
                        }
                        if (y + 1 <= n - 1 && grid[x][y + 1] == '1' && !visited[x][y + 1]) {
                            visited[x][y + 1] = true;
                            q.offer(new int[]{x, y + 1});
                        }
                    }
                    res++;
                }
            }
        }
        
        return res;
    }
}