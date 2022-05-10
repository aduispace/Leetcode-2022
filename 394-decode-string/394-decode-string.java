class Solution {
    public String decodeString(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char i : s.toCharArray()) {
            queue.offer(i);
        }
        return build(queue);
    }
    
    private String build(Queue<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                String cur = build(queue);
                for (int j = 0; j < num; j++) {
                    sb.append(cur);
                }
                num = 0;
            } else if (Character.isAlphabetic(ch)) {
                sb.append(ch);
            } else if (ch == ']') {
                break;
            }
        }
        
        return sb.toString();
    }
}