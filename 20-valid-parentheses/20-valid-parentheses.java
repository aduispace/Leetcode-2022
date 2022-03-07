class Solution {
    public boolean isValid(String s) {
        // (({{))}} not valid
        // ((({}))) valid
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty() || !isMatched(stack.pop(), s.charAt(i))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    private boolean isMatched(char a, char b) {
        if ((a == '{' && b == '}') || (a == '(' && b == ')') || (a == '[' && b == ']')) {
            return true;
        }   
        return false;
    }
}