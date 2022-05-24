class Solution {
    public int findPeakElement(int[] nums) {
        // O(logN)
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid + 1 < nums.length && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // this just returns mid!
        return left + (right - left) / 2;
    }
}