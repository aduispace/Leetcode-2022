class Solution {
    List<List<Integer>> res = new ArrayList<>();
    // Time O(N*N!) = total O(N!) results, each result take a for loop O(N)
    // Space to hold the results O(N!)
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        backtrack(nums, visited, path);
        
        return res;
    }
    
    private void backtrack(int[] nums, boolean[] visited, List<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        
        // for循环当前dfs决策树层的所有可能选择（同层）
        for (int i = 0; i < nums.length; i++) {
            // if (visited[i] || (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1])) {
            //     continue;
            // } 
            if (visited[i]) continue;
            // [1, 2, 2] 如果只是用nums[i - 1] == nums[i]判断那么所有2都被prune, 此时只要知道i-1被用过即可进这层，也就是i-1没被用过，才要跳过
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) continue;
            visited[i] = true;
            path.add(nums[i]);
            backtrack(nums, visited, path);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
        
        return;
    }
}