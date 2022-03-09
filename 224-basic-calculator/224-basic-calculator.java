class Solution {
    int i = 0;
    public int calculate(String s) {

        // 1 + 1 -> +1 +1
        // 
        // return helper("(" + s + ")");
        return helper("(" + s + ")");
    }
    
    private int helper(String s) {
        int sign = 1;
        int res = 0;
        int num = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
                i++;
            } else if (ch == '+' || ch == '-') {
                res += sign * num;
                sign = ch == '+' ? 1 : -1;
                num = 0;
                i++;
            } else if (ch == '(') {
                i++;
                res += sign * helper(s);
            } else if (ch == ')') {
                res += sign * num;
                i++;
                return res;
            } else {
                i++;
            }
        }
        
        return res;
    }
}