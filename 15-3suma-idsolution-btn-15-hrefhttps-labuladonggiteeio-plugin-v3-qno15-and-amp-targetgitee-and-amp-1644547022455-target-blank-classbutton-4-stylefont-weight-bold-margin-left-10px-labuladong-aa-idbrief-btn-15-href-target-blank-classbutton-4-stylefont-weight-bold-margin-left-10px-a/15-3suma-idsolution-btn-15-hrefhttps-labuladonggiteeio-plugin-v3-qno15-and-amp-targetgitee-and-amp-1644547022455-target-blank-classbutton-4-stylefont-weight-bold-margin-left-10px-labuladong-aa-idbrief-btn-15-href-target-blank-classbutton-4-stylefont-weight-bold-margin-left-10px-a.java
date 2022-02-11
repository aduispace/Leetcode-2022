class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // total complexity: O(NlogN + N^2)
        // sort: O(NlogN)
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // for + twoSum while loop : O(N^2)
        for (int i = 0; i < nums.length - 2; i++) {
            int target = 0 - nums[i];
            List<List<Integer>> res = twoSum(nums, target, i + 1);
            result.addAll(res);
            
            // need this to deduplicate the first candidate!!!
            while (i < nums.length - 2 && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return result;
    }
    
    private List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int left = start, right = nums.length - 1;
        
        
        // two pointer time: O(N)
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                int a = nums[left], b = nums[right];
                res.add(new ArrayList<Integer>(Arrays.asList(nums[start - 1], a, b)));
                
                // deduplicate candidate
                while (nums[left] == a && left < nums.length - 1) {
                    left++;
                }
                while (nums[right] == b && right > 0) {
                    right--;
                }
            } else if (sum > target) {
                int b = nums[right];
                
                // deduplicate candidate
                while (nums[right] == b && right > 0) {
                    right--;
                }
            } else {
                int a = nums[left];
                // deduplicate candidate
                while (nums[left] == a && left < nums.length - 1) {
                    left++;
                }
            }
        }
        return res;
    }
}

// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         if (nums.length < 3) {
//             return result;
//         }
        
//         HashSet<List<Integer>> deduplicatedResult = new HashSet<>();
              
//         for (int i = 0; i < nums.length - 2; i++) {
//             for (int j = i + 1; j < nums.length - 1; j++) {
//                 for (int m = j + 1; m < nums.length; m++) {
//                     int sum = nums[i] + nums[j] + nums[m];
//                     if (sum == 0) {
//                         ArrayList<Integer> cur = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[m]));
//                         cur.sort(Comparator.naturalOrder());
//                         if (!deduplicatedResult.contains(cur)) {
//                             result.add(cur);
//                             deduplicatedResult.add(cur);
//                         }
//                     }
//                 }
//             }
//         }
        
//         return result;
//     }
// }