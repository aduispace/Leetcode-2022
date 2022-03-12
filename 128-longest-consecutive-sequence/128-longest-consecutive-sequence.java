class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        
        for (int i : set) {
            int curRes = 0;
            // 这里要加这个优化，不然会超时，本质是只从每个consecutive nums的start num开始找
            if (set.contains(i - 1)) {
                continue;
            } else {
                while (set.contains(i + curRes)) {
                    curRes++;
                }
                res = Math.max(curRes, res);
            }
        }
        
        return res;
    }
}