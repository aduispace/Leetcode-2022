class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = nums[nums.length - 1];
        
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }
        
        int[] res = new int[nums.length];
        
        // initialize first and last in res
        res[0] = suffix[1];
        res[nums.length - 1] = prefix[nums.length - 2];
        
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = prefix[i - 1] * suffix[i + 1];
        }
        
        return res;
    }
}