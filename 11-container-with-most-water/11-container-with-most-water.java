class Solution {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int amount = getWaterAmount(left, right, height);
            if (maxArea < amount) maxArea = amount;
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
    
    private int getWaterAmount(int left, int right, int[] height) {
        return (right - left) * Math.min(height[left], height[right]);
    }
}