class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Coordinate> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        minHeap.offer(new Coordinate(0, 0, matrix[0][0]));
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        
        // 用最小堆做bfs
        // iterate k - 1 times, because it has been initialized with [0, 0]
        for (int i = 0; i < k - 1; i++) {
            Coordinate now = minHeap.poll();
            // go right to search
            if (now.i + 1 < n && !visited[now.i + 1][now.j]) {
                visited[now.i + 1][now.j] = true;
                minHeap.offer(new Coordinate(now.i + 1, now.j, matrix[now.i + 1][now.j]));
            }
            if (now.j + 1 < n && !visited[now.i][now.j + 1]) {
                visited[now.i][now.j + 1] = true;
                minHeap.offer(new Coordinate(now.i, now.j + 1, matrix[now.i][now.j + 1]));
            }
        }
        
        return minHeap.peek().val;
    }
    
    private class Coordinate {
        int i;
        int j;
        int val;
        Coordinate(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
}