class Solution {
    public int longestPalindrome(String s) {
        // https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        for (char ch : map.keySet()) {
            res += map.get(ch) % 2 == 0 ? map.get(ch) : map.get(ch) - 1;
        }
        
        return res < s.length() ? res + 1 : res;
    }
}