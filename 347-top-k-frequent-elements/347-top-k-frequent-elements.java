class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Queue<int[]> maxPQ = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        for (int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }
        
        for (int key : freqMap.keySet()) {
            maxPQ.offer(new int[]{key, freqMap.get(key)});
        }
        
        for (int i = 0; i < k; i++) {
            nums[i] = maxPQ.poll()[0];
        }
        
        return Arrays.copyOfRange(nums, 0, k);
    }
}