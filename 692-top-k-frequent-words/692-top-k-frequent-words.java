class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        Queue<Pair<String, Integer>> maxPQ = new PriorityQueue<>((a, b) -> { 
            if (b.getValue() == a.getValue()) {
                return a.getKey().compareTo(b.getKey());
            } else {
                return b.getValue() - a.getValue();
            }
        });
        
        // get frequency
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        // Pair<String, Integer> ans = new Pair <String, Integer> ("", 0);
        
        for (String key : map.keySet()) {
            maxPQ.offer(new Pair<String, Integer>(key, map.get(key)));
        }
        
        for (int i = 0; i < k; i++) {
            result.add(maxPQ.poll().getKey());
        }
        
        
        return result;
    }
}