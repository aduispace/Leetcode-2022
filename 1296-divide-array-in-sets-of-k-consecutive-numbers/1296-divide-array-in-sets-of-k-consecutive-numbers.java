class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        
        Map<Integer, Integer> treeMap = new TreeMap<>((a, b) -> a - b);
        for (int i : nums) {
            treeMap.put(i, treeMap.getOrDefault(i, 0) + 1);
        }
        
        // [1: 0, 2: 0, 3: 1, 4: 1, 5: 1, 6: 1] --- 
        
        // [1, 2, 3, 4]
        
        // j decrement from k - 1 is because the number from back should be more than number from front
        for (int i : treeMap.keySet()) {
            if (treeMap.get(i) > 0) {
                for (int j = k - 1; j >= 0; j--) {
                    if (!treeMap.containsKey(i + j) || treeMap.get(i + j) < treeMap.get(i)) {
                        return false;
                    } else {
                        treeMap.put(i + j, treeMap.get(i + j) - treeMap.get(i));
                    }
                }
            }
        }
        
        return true;
    }
}