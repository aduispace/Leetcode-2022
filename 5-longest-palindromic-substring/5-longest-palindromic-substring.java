class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        // Time Complexity: O(N^2)
        for (int i = 0; i < s.length(); i++) {
            // 单数子串和双数子串
            String odd = palindrome(s, i, i);
            String even = palindrome(s, i, i + 1);
            String curResult = odd.length() > even.length() ? odd : even;
            result = result.length() < curResult.length() ? curResult : result;
        }
        
        return result;
    }
    
    private String palindrome(String s, int left, int right) {
        if (s.length() <= 1) return s;
        // 注意start spanning condition 
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // span from middle, left go left, right go right
            left--;
            right++;
        }
        
        // left, right invalid; left + 1, right - 1 valid
        return s.substring(left + 1, right);
    }
}