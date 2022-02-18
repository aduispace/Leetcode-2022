class Solution {
    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder(s);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetter(sb.charAt(left))) {
                left++;
            } else if (!Character.isLetter(sb.charAt(right))) {
                right--;
            } else {
                char temp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, temp);
                left++;
                right--;
            }
        }
                
        return sb.toString();
    }
}