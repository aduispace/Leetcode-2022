class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {       
        traverse(graph, new ArrayList<Integer>(), 0);
        return res;
    }
    
    // acyclic, so no need to add visited metrics to track
    private void traverse(int[][] graph, List<Integer> path, int start) {
        // end condition, and edge cases
        if (start == graph.length - 1) {
            // 加入start 之后return前要move out start！！！！
            path.add(start);
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        } else if (graph.length == 0) {
            return;
        }
        
        path.add(start);
        for (int i : graph[start]) {
            traverse(graph, path, i);
        }
        path.remove(path.size() - 1);
        
        return;
    }
}