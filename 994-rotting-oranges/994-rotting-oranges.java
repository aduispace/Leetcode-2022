class Solution {
    public int orangesRotting(int[][] grid) {
        int total = 0;
        int count = 0;
        int time = -1;
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) total++;
                if (grid[i][j] == 2) {
                    // 加到queue里面的时候就mark true
                    visited[i][j] = true;
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        // no orange return 0
        if (total == 0) {
            return 0;
        }
        
        while (!q.isEmpty()) {
            int size = q.size();
            // 第一次处理的是全为2的情况，time先为-1
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                count++;
                
                if (x - 1 >= 0 && grid[x - 1][y] == 1 && !visited[x - 1][y]) {
                    visited[x - 1][y] = true;
                    q.offer(new int[]{x - 1, y});
                }
                
                if (x + 1 < m && grid[x + 1][y] == 1 && !visited[x + 1][y]) {
                    visited[x + 1][y] = true;
                    q.offer(new int[]{x + 1, y});
                }
                
                if (y - 1 >= 0 && grid[x][y - 1] == 1 && !visited[x][y - 1]) {
                    visited[x][y - 1] = true;
                    q.offer(new int[]{x, y - 1});
                }
                
                if (y + 1 < n && grid[x][y + 1] == 1 && !visited[x][y + 1]) {
                    visited[x][y + 1] = true;
                    q.offer(new int[]{x, y + 1});
                }
                
            }
            
            time++;
        }
        

        return count != total ? -1 : time;
    }

    
}