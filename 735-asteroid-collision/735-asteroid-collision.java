class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // [5, 7, -7, 10, -5, 6]
        // [5, 10, 6]
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = asteroids.length - 1; i >= 0; i--) {
            // 只有在stack top的元素为负（往左飞），当前元素为正（往右飞）的时候需要拿出来比较判断
            while (!stack.isEmpty() && i >= 0 && asteroids[i] > 0 && stack.peek() < 0) {
                int curPeek = stack.peek();
                if (curPeek + asteroids[i] > 0) {
                    // 去除栈顶
                    stack.pop();
                } else if (curPeek + asteroids[i] < 0) {
                    // 跳过当前
                    i--;
                } else {
                    // 相等两个都没了，所以去除栈顶也跳过当前
                    stack.pop();
                    i--;
                }
            }
            if (i >= 0) {
               stack.push(asteroids[i]);
            }
        }
                
        int[] result = new int[stack.size()];
        int i = 0;
        // 最后stack剩下的都是需要的元素
        while (!stack.isEmpty()) {
            result[i] = stack.pop();
            i++;
        }
        
        return result;
    }
}