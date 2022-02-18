class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (!Character.isLetter(s.charAt(left)) && !Character.isDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetter(s.charAt(right)) && !Character.isDigit(s.charAt(right))) {
                right--;
            } else if (!isSame(s.charAt(left), s.charAt(right))) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        
        return true;
    }
    
    private boolean isSame(char a, char b) {
        if (Character.toLowerCase(a) == Character.toLowerCase(b)) {
            return true;
        }
        return false;
    }
}