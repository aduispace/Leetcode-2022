class Solution {
    public int longestSubstring(String s, int k) {
        // Divide the problem into subproblems. (Divide Phase).
        // Repeatedly solve each subproblem independently and combine the result to              solve the original problem. (Conquer Phase).
        // divide and conquer: using recursion
        // O(N^2)
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
            // pivot is the point that split problems into two subProblems
            char pivot = s.charAt(i);
            if (freqMap[pivot - 'a'] < k) {
                return Math.max(helper(start, i - 1, s, k), helper(i + 1, end, s, k));
            }
        }
        // 这里返回end - start + 1是因为对于每一个子问题，如果pfreqMap[pivot - 'a'] < k的pivot找不到，说明找到符合要求的substring，长度就是end - start + 1
        return end - start + 1;
    }
}