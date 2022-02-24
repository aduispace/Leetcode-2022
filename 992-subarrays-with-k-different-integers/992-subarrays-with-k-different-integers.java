class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return maxNumberOfSubarraysWithKDistinct(nums, k) - maxNumberOfSubarraysWithKDistinct(nums, k - 1);
    }
    
    private int maxNumberOfSubarraysWithKDistinct(int[] nums, int k) {
        int i = 0, j = 0; // i for left(slow), j for right(fast)
        int result = 0;
        Map<Integer, Integer> rec = new HashMap<>();
        while (j < nums.length) {
            /**
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