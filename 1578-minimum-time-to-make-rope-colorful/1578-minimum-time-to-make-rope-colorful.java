class Solution {
    public int minCost(String colors, int[] neededTime) {
        colors = colors + '0';
        char[] arr = colors.toCharArray();
        int res = 0;
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        // [a, 4] [a, 1]
        // res = 2
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                pq.offer(new Pair<Character, Integer>(arr[i], neededTime[i]));
            } else {
                pq.offer(new Pair<Character, Integer>(arr[i], neededTime[i]));
                while (pq.size() > 1) {
                    res += pq.poll().getValue();
                }
                pq.poll();
            }
        }
        
        return res;
    }
}