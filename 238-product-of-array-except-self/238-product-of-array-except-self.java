class Solution {
    // 
    public int[] productExceptSelf(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        
        // 从左到右的前缀积，prefix[i] 是 nums[0..i] 的元素积
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        // 从右到左的前缀积，suffix[i] 是 nums[i..n-1] 的元素积
        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = nums[nums.length - 1];
        
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }
        
        int[] res = new int[nums.length];
        
        // 第一个和最后一个元素单独fill，initialize first and last in res
        res[0] = suffix[1];
        res[nums.length - 1] = prefix[nums.length - 2];
        
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = prefix[i - 1] * suffix[i + 1];
        }
        
        return res;
    }
}

// easier version: 左右跑两遍，第一遍存prefix product，第二遍存suffix product， O(1) extra space
// public int[] productExceptSelf(int[] nums) {
//     int[] result = new int[nums.length];
//     for (int i = 0, tmp = 1; i < nums.length; i++) {
//         result[i] = tmp;
//         tmp *= nums[i];
//     }
//     for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
//         result[i] *= tmp;
//         tmp *= nums[i];
//     }
//     return result;
// }