class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] result = new int[2];
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                // 提前返回避免超时。。。
                return result;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        
        return result;
    }
}