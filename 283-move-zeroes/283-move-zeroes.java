class Solution {
    public void moveZeroes(int[] nums) {
        // slow to assign non-zero element, fast to find non-zero element
        // the exit condition is slow reach the end of array
        int slow = 0, fast = 0;
        while (slow < nums.length) {
            if (fast < nums.length && nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            } else if (fast == nums.length) {
                nums[slow] = 0;
                slow++;
            } else {
                fast++;
            }
        }
    }
}