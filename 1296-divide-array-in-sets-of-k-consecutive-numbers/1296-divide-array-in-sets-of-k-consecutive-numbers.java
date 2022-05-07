class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
    
        // hashMap + sorted array    
        Arrays.sort(nums); // go through every number of nums, not the keySet()
        
        // approach 2: use a treeMap
        // j decrement from k - 1 is because the number from back should be more than number from front
        for (int i : nums) {
            if (map.get(i) > 0) {
                for (int j = 0; j < k; j++) {
                    if (!map.containsKey(i + j) || map.get(i + j) == 0) {
                        return false;
                    } else {
                        map.put(i + j, map.get(i + j) - 1);
                    }
                }
            }
        }
        
        return true;
    }
}