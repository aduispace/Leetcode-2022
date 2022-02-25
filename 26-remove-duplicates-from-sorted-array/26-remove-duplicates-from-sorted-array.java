class Solution {
    public int removeDuplicates(int[] nums) {
        // fast find first element that different with slow 
        // edge case [0, 1, 2, 3, 4, 5]
        // regular case [0, 1, 2, 3, 4, 3, 4]
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}