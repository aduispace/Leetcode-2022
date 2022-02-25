class Solution {
    public int removeDuplicates(int[] nums) {
        // fast find first element that different with slow 
        // edge case [0, 1, 2, 3, 4, 5]
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // slow would stop at the end index of first part of array, need to +1 to get its length
        return slow + 1;
    }
}