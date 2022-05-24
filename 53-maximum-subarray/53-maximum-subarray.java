class Solution {
    public int maxSubArray(int[] nums) {
        // [-2, -1, -4, 0, -1, 1, 2, -3, 1]
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int res = Integer.MIN_VALUE;
        
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(dp[i], res);
        }
        
        return res;
    }
}