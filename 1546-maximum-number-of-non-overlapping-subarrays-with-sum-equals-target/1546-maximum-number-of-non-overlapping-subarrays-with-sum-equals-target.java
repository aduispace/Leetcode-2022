class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // sum to lastIndex
        int lastIndex = -1;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - target) && map.get(sum - target) >= lastIndex) {
                res++;
                lastIndex = i;
            }
            map.put(sum, i);
        }
        
        return res;
    }
}

/***
Time: O(N^2)
class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        // Time: HashMap + Prefix Sum, O(N^2)
        // [1, 1, 1, 1, 1] -> [0, 1, 2, 3, 4, 5]
        // [-1,3,5,1,4,2,-9] -> [0, -1, 2, 7, 8, 12, 14, 5]
        int res = 0;
        int[] preSum = new int[nums.length + 1];
        // preSum to its position
        Map<Integer, Integer> map = new HashMap<>(); 
        preSum[0] = 0;
        map.put(0, 0);

        for (int i = 1; i < nums.length; i++) {
            preSum[i] = nums[i] + preSum[i - 1];
            map.put(preSum[i], i);
        }
        
        for (int i = 0; i < preSum.length; i++) {
            int curMax = 0;
            for (int j = i; j < preSum.length; j++) {
                int key = preSum[j] + target;
                if (map.containsKey(key)) {
                    curMax++;
                    j = map.get(key);
                }
            }
            res = Math.max(curMax, res);
        }
        
        return res;
    }
}

**/