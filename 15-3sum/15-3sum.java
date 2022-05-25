class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            // 之前算过的都要去掉
            
            if (i > 0 && nums[i] == nums[i - 1]) {
                // deduplicate!
                continue;
            }
            
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1; 
            // nums[left] and nums[right] cannot be same, no reuse for same number
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < nums.length && left - 1 >= 0 && nums[left] == nums[left - 1]) {
                        // deduplicated!
                        left++;
                    }
                    // while (right - 1 >= 0 && nums[right] == nums[right - 1]) {
                    //     // deduplicated!
                    //     right--;
                    // }
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        
        }
        
        return res;
    }
    
}