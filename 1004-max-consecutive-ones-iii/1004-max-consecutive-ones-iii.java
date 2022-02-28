class Solution {
    public int longestOnes(int[] nums, int k) {
        // Number of MaxAppearance number/char, but in this question, we only flip 0 to 1, so just need to record number of 1 appearance
        int numOfOne = 0;
        int left = 0, result = 0;
        
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 1) numOfOne++;
            while (k < right - left + 1 - numOfOne) {
                if (nums[left] == 1) numOfOne--;
                left++;
            }
            
            result = Math.max(result, right - left + 1);
        }
        
        return result;
    }
}