class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int n = nums.length;
        int left = 0, right = nums.length - 1;
        
        // 双指针: [-4,-1,0,3,10] 左右开始往中间都是一个递减序列，所以result从后往前assign
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