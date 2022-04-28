class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        backtrack(nums, path, 0);
        
        return res;
    }
    
    // subset因为元素不能重复使用，backtrack tree结构不一样
    
    private void backtrack(int[] nums, List<Integer> path, int start) {
        res.add(new ArrayList<Integer>(path));
        
        // dfs level from start
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            // cannot go back, so start = i + 1
            backtrack(nums, path, i + 1);
            path.remove(path.size() - 1);
        }
        
        return;
    }
}