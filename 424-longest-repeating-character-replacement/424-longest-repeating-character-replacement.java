class Solution {
    public int characterReplacement(String s, int k) {
        // set maxFreq for frequency of maximum appearing letter
        // [B,B,A,A,A,C,B,A] 3
        int left = 0, right = 0;
        Map<Character, Integer> freq = new HashMap<>();
        int result = 0, maxFreq = 0;
        while (right < s.length()) {
            char rightCh = s.charAt(right);
            freq.put(rightCh, freq.getOrDefault(rightCh, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(rightCh));
            right++;
            // window长度-最大出现次数字母长度，要 <= K
            if ((right - left) - maxFreq > k) {
                char leftCh = s.charAt(left);
                freq.put(leftCh, freq.getOrDefault(leftCh, 0) - 1);
                // 理解这个更新条件很重要
                maxFreq = Math.max(maxFreq, freq.get(leftCh));
                left++;
            }
            
            result = Math.max(right - left, result);
        }
        
        return result;
    }
    
}