class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<Integer>(), 0);
        
        return res;
    }
    
    private void backtrack(int[] nums, List<Integer> path, int start) {
        res.add(new ArrayList<Integer>(path));
        
        for (int i = start; i < nums.length; i++) {
            // 当前层的选择，第一个可以进去，第二个开始判断如果一样就不进去
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            path.add(nums[i]);
            backtrack(nums, path, i + 1);
            path.remove(path.size() - 1);
        }
        
        return;
    }
}