class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        // stack definition: monotone stack that all elements on the right side greater than current temperatures[i]
        // pop first, then determine the current result value (distance) based on left elements in stack
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek() - i;
            }
            // 最后再把当前元素push进去，之前都是当前元素和它右边元素的比较
            stack.push(i);
        }
        
        return result;
    }
}