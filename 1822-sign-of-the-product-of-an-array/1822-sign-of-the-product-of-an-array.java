class Solution {
    public int arraySign(int[] nums) {
        int product = 1;
        for (int i : nums) {
            if (i > 0) {
                product *= 1;
            } else if (i < 0) {
                product *= -1;
            } else {
                product *= 0;
            }
        }
        
        return product == 0 ? 0 : (product > 0 ? 1 : -1);
    }
}