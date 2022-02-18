class Solution {
    public int trap(int[] height) {
        // 每个位置i存水的量为 min(leftMax[i], rightMax[i]) - height[i]
        int trap = 0;
        if (height.length < 3) {
            return trap;
        }
        int leftMax = height[0], rightMax = height[height.length - 1]; // 边界线不能存水
        int left = 0, right = height.length - 1;
        while (left <= right) {
            if (leftMax < rightMax) {
                // min(leftMax, rightMax), in this case it is leftMax
                // 先update leftMax！！！确定当前left高度如果比leftmax高，此处不存水
                leftMax = Math.max(height[left], leftMax);
                trap += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(height[right], rightMax);
                trap += rightMax - height[right];
                right--;
            }
        }
        
        return trap;
        
        // 注意最后trap先加完才move指针，别忘了算left=right的情况的水
        // return trap + Math.min(Math.max(height[left], leftMax), Math.max(height[right], rightMax)) - height[left];
    }
}