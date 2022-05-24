class Solution {
    public int maxSubArray(int[] nums) {
        // [-2, -1, -4, 0, -1, 1, 2, -3, 1]
        // O(N) dynamic programming
        int[] dp = new int[nums.length];
        int res = nums[0];

        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }
        
        return res;
    }
}