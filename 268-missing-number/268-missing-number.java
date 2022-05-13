class Solution {
    public int missingNumber(int[] nums) {
        // 0 + 1 + 2 + 3 = 6
        int suppose = 0;
        int actual = 0;
        for (int i = 0; i <= nums.length; i++) {
            suppose += i;
        }    
        
        for (int i : nums) {
            actual += i;
        }
        
        return suppose - actual;
    }
}