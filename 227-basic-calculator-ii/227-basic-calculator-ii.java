class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char sign = '+';
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            // (!Character.isDigit(ch) && ch != ' ')
            // i为最后一位的时候要把剩余的sign和num放入栈，所以这里和上面要写两个if
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                switch (sign) {
                    case '+': stack.push(num);
                    break;
                    case '-': stack.push(0 - num);
                    break;
                    case '*': stack.push(stack.pop() * num);
                    break;
                    case '/': stack.push(stack.pop() / num);
                    break;
                }
                sign = ch;
                num = 0;
            }
            i++;
        }
              
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
}