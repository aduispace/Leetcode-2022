class Solution {
    public String reorganizeString(String s) {
        // [aaaaaac] this returns ""
        // [aaabbc] this return reorganized string
        
        // Time: O(3NLogK), k is different # of char, worst O(3NLogN), Space: O(N)
        char[] res = new char[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        Queue<Pair<Character, Integer>> maxPQ = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        for (char i : s.toCharArray()) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (char key : map.keySet()) {
            maxPQ.offer(new Pair<Character, Integer>(key, map.get(key)));
        }
        
        int i = 0;
        while (!maxPQ.isEmpty()) {
            Pair<Character, Integer> first = maxPQ.poll();
            if (i == 0 || res[i - 1] != first.getKey()) {
                res[i] = first.getKey();
                int count = first.getValue() - 1;
                if (count > 0) maxPQ.offer(new Pair<Character, Integer>(res[i], count));
            } else {
                // if second is not available, return ""
                if (maxPQ.isEmpty()) return "";
                Pair<Character, Integer> second = maxPQ.poll();
                res[i] = second.getKey();
                int count = second.getValue() - 1;
                if (count > 0) maxPQ.offer(new Pair<Character, Integer>(res[i], count));
                maxPQ.offer(first);
            }
            i++;
        }
        
        return new String(res);
    }
}