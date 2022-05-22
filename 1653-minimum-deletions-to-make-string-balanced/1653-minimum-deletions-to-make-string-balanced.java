class Solution {
    public int minimumDeletions(String s) {
        // [aababbab] -> [b: 3, a: 2]
        // [bbaaaaabb] -> [b: 2, ]
        int res = 0;
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    res++;
                    stack.pop();
                }
            }
            
            if (c == 'b') {
                stack.push('b');
            }
        }
        
        return res;
    }
}