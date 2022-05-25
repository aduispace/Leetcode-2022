class Solution {
    public int[] sortArray(int[] nums) {
        // quick sort
        
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void quickSort(int[] nums, int low, int high) {
        if (nums.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        // left pointer at low, right pointer at high
        int left = low;
        int right = high;
        int pivot = nums[left];
        
        while (left < right) {
            // 从右往左找到比pivot小的，扔到左边，相等扔到左边右边都可以
            while (left < right && pivot <= nums[right]) {
                right--;
            }
            nums[left] = nums[right];
            // 从左往右找到比pivot大的，扔到右边，相等扔到左边右边都可以
            while (left < right && pivot >= nums[left]) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        
        quickSort(nums, low, left - 1);
        quickSort(nums, left + 1, high);
    }
}