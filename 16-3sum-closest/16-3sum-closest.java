class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // time: O(n^2 + nlogn) = O(n^2)
        
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    // update diff
                    if (sum - target < Math.abs(diff)) diff = sum - target;
                    right--;
                } else {
                    // update diff
                    if (target - sum < Math.abs(diff)) diff = sum - target;
                    left++;
                }
            }
        }
        
        return target + diff;
    }
}