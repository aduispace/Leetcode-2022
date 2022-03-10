class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                stack.push(1);
            } else {
                if (stack.peek() + 1 == k) {
                    sb.delete(i + 1 - k, i + 1);
                    i = i - k;
                    stack.pop();
                } else {
                    stack.push(stack.pop() + 1);
                }
            }
        }
        
        return sb.toString();

    }
}