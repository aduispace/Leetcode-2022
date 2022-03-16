class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; k > 0; k--, i--) {
            if (k == 1) {
                return nums[i];
            }
        }
        
        return 0;
    }
    

}