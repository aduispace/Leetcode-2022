class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window:
        Map<Character, Integer> rec = new HashMap<>();
        int i = 0, j = 0;
        int longest = 0;

        while (j < s.length()) {
            char right = s.charAt(j);
            rec.put(right, rec.getOrDefault(right, 0) + 1);
            while (rec.getOrDefault(right, 0) > 1) {
                char left = s.charAt(i);
                rec.put(left, rec.getOrDefault(left, 0) - 1);
                i++;
            }
            j++;

            
            longest = Math.max(j - i, longest);
        }
        
        return longest;
    }
}