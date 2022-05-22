class Solution {
    public int minDeletions(String s) {
        // [3, 3, 2]
        Set<Integer> freqSet = new HashSet<>();
        int[] freq = new int[26];
        int res = 0;
        
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        // [2, 3, 3]
        for (int i = 0; i < freq.length; i++) {
            while (freqSet.contains(freq[i]) && freq[i] > 0) {
                freq[i]--;
                res++;
            }
            freqSet.add(freq[i]);
        }
        
        return res;
    }
}