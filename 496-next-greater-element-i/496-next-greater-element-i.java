class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> positionMap = new HashMap<>();
        int[] result = new int[nums1.length];
        Deque<Integer> stack = new ArrayDeque<>();
        
        // mono-stack: for every nextGreater problem, it stores every greater element from nums2[i] from right side
        for (int i = 0; i < nums1.length; i++) {
            positionMap.put(nums1[i], i);
        }
        
        for (int i = nums2.length - 1; i >= 0; i--) {
            // 单调栈处理顺序 1.因为stack FILO特性，反方向遍历，先pop直到找到valid的元素 2. 根据要求assign to result 3.最后再push当前元素
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            } 
            int curRes = stack.isEmpty()? -1 : stack.peek();
            if (positionMap.containsKey(nums2[i])) {
                int pos = positionMap.get(nums2[i]);
                result[pos] = curRes;
            }
            stack.push(nums2[i]);
        }
        
        return result;
    }
}