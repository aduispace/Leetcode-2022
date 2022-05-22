// For each group of continuous same characters,
// we need cost = sum_cost(group) - max_cost(group)

class Solution {
    // Time O(N)
    public int minCost(String s, int[] cost) {
        int res = 0, max_cost = 0, sum_cost = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            if (i > 0 && s.charAt(i) != s.charAt(i - 1)) {
                res += sum_cost - max_cost;
                sum_cost = max_cost = 0;
            }
            sum_cost += cost[i];
            max_cost = Math.max(max_cost, cost[i]);
        }
        res += sum_cost - max_cost;
        return res;
    }

}
/**
class Solution {
    public int minCost(String colors, int[] neededTime) {
        // O(NlogN)
        
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

*/