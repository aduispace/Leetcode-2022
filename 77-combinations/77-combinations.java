class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> path = new ArrayList<>();
        backtrack(n, k, 1, path);
        
        return res;
    }
    
    private void backtrack(int n, int k, int start, List<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<Integer>(path));
        }
        
        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(n, k, i + 1, path);
            path.remove(path.size() - 1);
        }
        
        return;
    }
}