class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> stack = new ArrayDeque<>();
         
        for (int i = 0; i < sb.length(); i++) {
            // stack stores adjacent number of equal letters 
            // 整个循环对sb而不是s判断！！
            if (i == 0 || sb.charAt(i) != sb.charAt(i-1)) {
                stack.push(1);
            } else {
                int count = stack.pop() + 1;
                if (count == k) {
                    // be careful the delete start/end
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    stack.push(count);
                }
            }
        }
        
        return sb.toString();
    }
}