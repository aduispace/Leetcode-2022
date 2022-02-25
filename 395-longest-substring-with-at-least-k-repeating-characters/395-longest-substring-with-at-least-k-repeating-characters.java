class Solution {
    public int longestSubstring(String s, int k) {
        // divide and conquer 
        return helper(0, s.length() - 1, s, k);
    }
    
    private int helper(int start, int end, String s, int k) {
        if (end - start + 1 < k) return 0;
        int[] freqMap = new int[26];
        int res = 0;
        for (int i = start; i <= end; i++) {
            // fill the frequency map
            freqMap[s.charAt(i) - 'a']++;
        }
        for (int i = start; i <= end; i++) {
            char pivot = s.charAt(i);
            if (freqMap[pivot - 'a'] < k) {
                return Math.max(helper(start, i - 1, s, k), helper(i + 1, end, s, k));
            }
        }
        
        return end - start + 1;
    }
}