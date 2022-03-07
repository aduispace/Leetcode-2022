class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // [1, 3, 5, 6, 7, 10, 2, 4] [1, 3, 5, 6, 7, 10, 2, 4]
        // [3, 5, 6, 7, 10, 4, 5]
        // [1 3 5 6 7 10]
        // follow up question of next greater element: 
        // 先把nums里面数字用stack处理一遍，也可以取模one pass: 
        
        // for (int i = 2 * nums.length - 1; i >= 0; --i) {
        //     while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
        //         stack.pop();
        //     }
        //     res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
        //     stack.push(i % nums.length);
        // }
        
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[nums.length];
        
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            stack.push(nums[i]);
        }
        
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        
        return result;
    }
}