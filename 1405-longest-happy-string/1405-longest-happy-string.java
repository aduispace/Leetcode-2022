class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((i, j) -> j.getValue() - i.getValue());
        int count = 0;
        StringBuilder res = new StringBuilder();
        
        if (a != 0) pq.offer(new Pair<Character, Integer>('a', a));
        if (b != 0) pq.offer(new Pair<Character, Integer>('b', b));
        if (c != 0) pq.offer(new Pair<Character, Integer>('c', c));
        
        while (!pq.isEmpty()) {
            Pair<Character, Integer> candidate = pq.poll();
            if (res.length() > 0 && candidate.getKey() == res.charAt(res.length() - 1)) {
                count++;
            } else {
                count = 1;
            }
            if (count >= 3) {
                if (pq.isEmpty()) {
                    break;
                } else {
                    Pair<Character, Integer> next = pq.poll();
                    res.append(next.getKey());
                    int remainNum = next.getValue() - 1;
                    if (remainNum > 0) {
                        pq.offer(new Pair<>(next.getKey(), next.getValue() - 1));
                    }
                    // reset pq and count
                    count = 1;
                    pq.offer(candidate);
                }
            } else {
                res.append(candidate.getKey());
                int remainNum = candidate.getValue() - 1;
                if (remainNum > 0) {
                    pq.offer(new Pair<>(candidate.getKey(), candidate.getValue() - 1));
                }
            }
        }
        
        return res.toString();

    }
}