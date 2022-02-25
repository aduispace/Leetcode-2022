class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        // [0, 1, 2, 2, 3, 0, 4, 2], val = 2 before
        //  s
        //  f
        //     s
        //     f
        //        s
        //              f
        // [0, 1, 3, 2, 2, 0, 4, 2]
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        
        return slow; // slow is pointing at first val in second part of array
    }
}