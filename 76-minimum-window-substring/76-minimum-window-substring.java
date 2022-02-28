class Solution {
    public String minWindow(String s, String t) {
        // sliding window
        // window shrink condition: if current substring is valid, shrink from left
        // needs two maps: 1. record letters in string t  2. record letters in current window
        // 只记录unique letter count remaining，比如aabc 就是3 (a, b, c)
        
        int[] map = new int[256];
        int left = 0, targetRemainCount = 0;
        String result = "";
        for (int i = 0; i < t.length(); i++) {
            if (map[t.charAt(i) - 'A'] == 0) targetRemainCount++;
            map[t.charAt(i) - 'A']++;
        }
        
        // original map with number of each char in t is changed now, we need that info when shrinking
        // we need deep copy of array here!!! not reference!!!
        int[] windowCount = new int[256];
        for (int right = 0; right < s.length(); right++) {
            windowCount[s.charAt(right) - 'A']++;
            if (windowCount[s.charAt(right) - 'A'] == map[s.charAt(right) - 'A']) {
                targetRemainCount--;
            }
            while (left < s.length() && targetRemainCount <= 0) {
                String curResult = right == s.length() - 1 ? s.substring(left) : s.substring(left, right + 1);
                result = result.length() == 0 || result.length() >= curResult.length() ? curResult : result;
                windowCount[s.charAt(left) - 'A']--;
                if (windowCount[s.charAt(left) - 'A'] < map[s.charAt(left) - 'A']) {
                    targetRemainCount++;
                }
                left++;
            }
        }
        
        return result;
    }
    
}