class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Set<String> dict = new HashSet<>(wordDict);
//         Map<String, Boolean> memo = new HashMap<>();
//         return checkWordBreak(s, memo, dict);
//     }
    
//     private boolean checkWordBreak(String s, Map<String, Boolean> memo, Set<String> dict) {
//         if (memo.containsKey(s)) {
//             return memo.get(s);
//         }
//         if (dict.contains(s)) {
//             memo.put(s, true);
//             return true;
//         }
//         for (int i = 0; i <= s.length(); i++) {
//             String left = s.substring(0, i);
//             String right = s.substring(i);
//             if (dict.contains(left) && checkWordBreak(right, memo, dict)) {
//                 memo.put(s, true);
//                 return true;
//             }
//         }
//         memo.put(s, false);
//         return false;
//     }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> memo = new HashMap<>();
        return checkWordBreak(s, memo, wordDict);
    }
    
    private boolean checkWordBreak(String s, Map<String, Boolean> memo, List<String> wordDict) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        if (s.length() == 0) {
            return true;
        }
        for (String word : wordDict) {
            if (s.startsWith(word) && checkWordBreak(s.substring(word.length()), memo, wordDict)) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }

    
}

/*** Brute Force: Time O(2^N), n为string s 的长度，在每个位置都可以选择分割或者不分割（2种选择）
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String str : wordDict) {
            set.add(str);
        }
        
        return checkWordBreak(s, 0, set);
    }
    
    private boolean checkWordBreak(String s, int start, Set<String> set) {
        if (start >= s.length()) {
            return true;
        }
        for (int i = start; i <= s.length(); i++) {
            String part = s.substring(start, i); // [start, i)
            if (set.contains(part)) {
                if (checkWordBreak(s, i, set)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

***/