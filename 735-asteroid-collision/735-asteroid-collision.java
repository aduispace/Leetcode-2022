class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // [5, 7, -7, 10, -5, 6]
        // [5, 10, 6]
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = asteroids.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && i >= 0 && asteroids[i] > 0 && stack.peek() < 0) {
                int curPeek = stack.peek();
                if (curPeek + asteroids[i] > 0) {
                    stack.pop();
                } else if (curPeek + asteroids[i] < 0) {
                    i--;
                } else {
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
        while (!stack.isEmpty()) {
            result[i] = stack.pop();
            i++;
        }
        
        return result;
    }
}