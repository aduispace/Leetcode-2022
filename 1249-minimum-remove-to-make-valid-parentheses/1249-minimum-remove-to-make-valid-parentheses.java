class Solution {
    public String minRemoveToMakeValid(String s) {
        // stack for left parentheses position
        // Time O(n), Space O(n)
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    sb.deleteCharAt(i);
                    i = i - 1;
                }
            }
        }
        
        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }
        
        return sb.toString();
    }
}