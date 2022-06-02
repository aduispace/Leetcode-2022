class Solution {
    public int minSteps(String s, String t) {
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        int res = 0;
        
        for (char c : s.toCharArray()) {
            sArr[c - 'a'] += 1;
        }
        
        for (char c : t.toCharArray()) {
            tArr[c - 'a'] += 1;
        }
        
        for (int i = 0; i < 26; i++) {
            if (sArr[i] > tArr[i]) {
                res += sArr[i] - tArr[i];
            }
        }
        
        return res;
    }
}