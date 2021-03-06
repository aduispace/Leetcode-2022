class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> rec = new HashMap<>();
        // sliding window [left, right]
        int left = 0, right = 0;
        int distinct = 0;
        int result = 0;
        while (right < s.length()) {
            char chRight = s.charAt(right);
            rec.put(chRight, rec.getOrDefault(chRight, 0) + 1);
            if (rec.getOrDefault(chRight, 0) == 1) {
                distinct++;
            }
            // in any case we could move right border, just move left to shrink the distinct: `if (distinct <= k)` condition is useless in this case because it would go through move left of window to keep distinct at most K
            right++;
            while (left < s.length() && distinct > k) {
                char chLeft = s.charAt(left);
                rec.put(chLeft, rec.getOrDefault(chLeft, 0) - 1);
                if (rec.getOrDefault(chLeft, 0) == 0) {
                    distinct--;
                }
                left++;
            }
            
            result = Math.max(result, right - left);
        }
        
        return result;
    }
}