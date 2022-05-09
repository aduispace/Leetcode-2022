class Solution {
    public boolean validTree(int n, int[][] edges) {
        UF unionFind = new UF(n);
        for (int[] edge : edges) {
            if (!unionFind.connected(edge[0], edge[1])) {
                unionFind.union(edge[0], edge[1]);
            } else {
                return false;
            }
        }
        
        return unionFind.count == 1;
    }
    
    public class UF {
        int count;
        int parent[];
        
        // constructor
        public UF(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            
            if (rootA == rootB) return;
            
            // update the root parent to another!!!
            parent[rootA] = rootB;
            count--;
        }
        
        // use recursion to do path compression
        public int find(int a) {
            if (parent[a] != a) {
                parent[a] = find(parent[a]);
            }
            return parent[a];
        } 
        
        public boolean connected(int a, int b) {
            return find(a) == find(b);
        }
        
    }
}