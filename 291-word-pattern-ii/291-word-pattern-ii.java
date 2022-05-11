class Solution {
    Map<Character, String> map = new HashMap<>();
    
    // divide and conquer
    public boolean wordPatternMatch(String pattern, String s) {
        if (pattern.length() > s.length()) return false;
                
        return match(pattern, s, 0, 0);
    }
    
    private boolean match(String pattern, String s, int pPos, int sPos) {
        if (pPos == pattern.length() && sPos == s.length()) {
            return true;
        } else if (pPos == pattern.length() || sPos == s.length()) {
            return false;
        }
        
        char cur = pattern.charAt(pPos);

        for (int i = sPos; i <= s.length(); i++) {
            
            // substring [)
            String part = s.substring(sPos, i);
            
            if (part.length() == 0) {
                continue;
            }
            
            if (map.containsKey(cur) && map.get(cur).equals(part)) {
                if (match(pattern, s, pPos + 1, i)) {
                    return true;
                }
            } else if (!map.containsKey(cur) && !map.containsValue(part)){
                map.put(cur, part);
                if (match(pattern, s, pPos + 1, i)) return true;
                map.remove(cur);
            }
        }
        
        return false;
    }
}