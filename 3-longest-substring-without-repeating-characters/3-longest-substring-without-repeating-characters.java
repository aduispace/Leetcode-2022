class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        int j = 0, i = 0;
        int res = 0;
        
        while (j < s.length()) {
            if (!set.contains(arr[j])) {
                set.add(arr[j]);
                j++;
            } else {
                while (set.contains(arr[j])) {
                    set.remove(arr[i]);
                    i++;
                }
            }
            res = Math.max(res, j - i);
        }
        
        return res;
    }
}




//         // sliding window:
//         Map<Character, Integer> rec = new HashMap<>();
//         int i = 0, j = 0;
//         int longest = 0;

//         while (j < s.length()) {
//             char right = s.charAt(j);
//             rec.put(right, rec.getOrDefault(right, 0) + 1);
//             // j多跑了一步，j在当前right后面一位
//             j++;
//             while (rec.getOrDefault(right, 0) > 1) {
//                 char left = s.charAt(i);
//                 rec.put(left, rec.getOrDefault(left, 0) - 1);
//                 i++;
//             }
            
//             // 不能count map size因为有些元素value为0，
//             longest = Math.max(j - i, longest);
//         }
        
//         return longest;
    