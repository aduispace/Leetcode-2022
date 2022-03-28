class Solution {

    Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
    
    public int longestSubarray(int[] nums, int limit) {
        int longest = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
            minHeap.offer(nums[i]);
            if (this.maxDiff() <= limit) {
                longest = Math.max(i - left + 1, longest);
            } else {
                while (left < i && this.maxDiff() > limit) {
                    maxHeap.remove(nums[left]);
                    minHeap.remove(nums[left]);
                    left++;
                }
                longest = Math.max(i - left + 1, longest);
            }
        }
        
        return longest;
    }
    
    private int maxDiff() {
        int max = maxHeap.peek();
        int min = minHeap.peek();
        return max - min;
    }
}