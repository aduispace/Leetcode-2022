class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
                
        int a = lower; // a is the left bound
        
        // [4, 6, 80] [0, 99]
        for (int i = 0; i < nums.length; i++) {
            if (a < nums[i]) {
                res.add(generateStr(a, nums[i] - 1));
            }
            a = nums[i] + 1;    
        }
        
        if (a <= upper || nums.length == 0) {
            res.add(generateStr(a, upper));
        }
        
        return res;
    }
    
    private String generateStr(int a, int b) {
        return a == b ? String.valueOf(a) : String.valueOf(a) + "->" + String.valueOf(b);
    }
}