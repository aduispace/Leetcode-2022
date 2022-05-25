class Solution {
    boolean res = true;
    
    // Time: O(N*V) vertices
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n + 1]; // index starts with 1
        boolean[] relations = new boolean[n + 1];
        buildGraph(graph, dislikes);
        
        for (int i = 1; i < n + 1; i++) {
            traverse(graph, i, visited, relations);
        }
        
        return res;
    }
    
    private void traverse(Map<Integer, Set<Integer>> graph, int i, boolean[] visited, boolean[] relations) {
        if (!visited[i]) {
            visited[i] = true;
            for (int neighbor : graph.getOrDefault(i, new HashSet<>())) {
                if (!visited[neighbor]) {
                    relations[neighbor] = !relations[i];
                    traverse(graph, neighbor, visited, relations);
                } else {
                    if (relations[neighbor] == relations[i]) {
                        res = false;
                        return;
                    }
                }
            }
        }
    }
    
    private void buildGraph(Map<Integer, Set<Integer>> graph, int[][] dislikes) {
        // undirected graph, add both sides
        for (int[] dislike : dislikes) {
            if (graph.containsKey(dislike[0])) {
                graph.get(dislike[0]).add(dislike[1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(dislike[1]);
                graph.put(dislike[0], set);
            }
            if (graph.containsKey(dislike[1])) {
                graph.get(dislike[1]).add(dislike[0]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(dislike[0]);
                graph.put(dislike[1], set);
            }
        }
    }
}