class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // exact(k) = atMost(K) - atMost(K - 1)
        return maxNumberOfSubarraysWithKDistinct(nums, k) - maxNumberOfSubarraysWithKDistinct(nums, k - 1);
    }
    // ！！！模版代码：
    private int maxNumberOfSubarraysWithKDistinct(int[] nums, int k) {
        int i = 0, j = 0; // i for left(slow), j for right(fast)
        int result = 0;
        Map<Integer, Integer> rec = new HashMap<>();
        while (j < nums.length) {
            /** 以右边快指针为固定，收缩左边慢指针，找到正好为k的区间停止，满足的subarray数量为：j - i + 1;
            move fast pointer j, count k first, and the update record map, finally move pointer j
            */
            if (rec.getOrDefault(nums[j], 0) == 0) { // rec.containsKey() works too
                k--; // one valid number added in, k--
            }
            rec.put(nums[j], rec.getOrDefault(nums[j], 0) + 1);
            j++;
            /**
            move slow pointer i, update record map first, then count k, finally move pointer j, untill k == 0 which find the correct sliding window
            */
            while (k < 0) {
                rec.put(nums[i], rec.getOrDefault(nums[i], 0) - 1);
                if (rec.getOrDefault(nums[i], 0) == 0) {
                    k++; // one valid number moved out, k++
                }
                i++;
            }
            result += j - i + 1;
        }
        
        return result;
    }
    
}

//         // Brute force: O(N^2), time limit exceed
//         Set<Integer> rec = new HashSet<>();
//         int result = 0;
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i; j < nums.length; j++) {
//                 rec.add(nums[j]);
//                 if (rec.size() == k) {
//                     result++;
//                 }
//             }
//             rec.clear();
//         }
        
//         return result;