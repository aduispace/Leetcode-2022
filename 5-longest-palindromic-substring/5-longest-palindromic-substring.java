class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String odd = palindrome(s, i, i);
            String even = palindrome(s, i, i + 1);
            String curResult = odd.length() > even.length() ? odd : even;
            result = result.length() < curResult.length() ? curResult : result;
        }
        
        return result;
    }
    
    private String palindrome(String s, int left, int right) {
        if (s.length() <= 1) return s;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // span from middle, left go left, right go right
            left--;
            right++;
        }
        
        return s.substring(left + 1, right);
    }
}