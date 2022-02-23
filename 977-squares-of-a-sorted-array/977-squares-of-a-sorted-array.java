class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int n = nums.length;
        int left = 0, right = nums.length - 1;
        while (n > 0) {
            if (Math.abs(nums[left]) <= Math.abs(nums[right])) {
                result[--n] = nums[right] * nums[right];
                right--;
            } else {
                result[--n] = nums[left] * nums[left];
                left++;
            }
        }
        
        return result;
    }
}