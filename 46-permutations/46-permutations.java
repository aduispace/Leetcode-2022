class Solution {
    // Time Complexity: O(N!)
    // Space: O(N!)
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<Integer>(), used);
        return res;
    }
    
    private void backtrack(int[] nums, List<Integer> path, boolean[] used) {
        // end condition
        if (path.size() == nums.length) {
            // java回溯一定要记得不能直接add path reference！！！！！！ 要copy过去！！！！！
            res.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                backtrack(nums, path, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
        
        return;
    }
}