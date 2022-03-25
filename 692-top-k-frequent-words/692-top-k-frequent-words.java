class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // maxHeap做法，也可以用minheap做更快
        // maxheap存n个元素，minheap只存top k个
        // max heap time: O(nlogn + Klogn) = O(nlogn), nlogn add all elements to heap, klogN pop k words
        
        // min heap time: O(NlogK + KlogK) = O(NlogK)
        
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        Queue<Pair<String, Integer>> minPQ = new PriorityQueue<>((a, b) -> { 
            if (b.getValue() == a.getValue()) {
                // for same values, the larger lexicographical would be poll out, the lexicographically smaller one would be remaining, which is required.
                return b.getKey().compareTo(a.getKey());
            } else {
                return a.getValue() - b.getValue();
            }
        });
        
        // get frequency
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        // Pair<String, Integer> ans = new Pair <String, Integer> ("", 0);
        
        for (String key : map.keySet()) {
            minPQ.offer(new Pair<String, Integer>(key, map.get(key)));
            if (minPQ.size() > k) {
                minPQ.poll();
            }
        }
        
        while (!minPQ.isEmpty()) {
            // because lower element came out first, we need append to head
            result.add(0, minPQ.poll().getKey());
        }
        
        
        return result;      
        
        
        
//         Map<String, Integer> map = new HashMap<>();
//         List<String> result = new ArrayList<>();
//         Queue<Pair<String, Integer>> maxPQ = new PriorityQueue<>((a, b) -> { 
//             if (b.getValue() == a.getValue()) {
//                 return a.getKey().compareTo(b.getKey());
//             } else {
//                 return b.getValue() - a.getValue();
//             }
//         });
        
//         // get frequency
//         for (String str : words) {
//             map.put(str, map.getOrDefault(str, 0) + 1);
//         }
        
//         // Pair<String, Integer> ans = new Pair <String, Integer> ("", 0);
        
//         for (String key : map.keySet()) {
//             maxPQ.offer(new Pair<String, Integer>(key, map.get(key)));
//         }
        
//         for (int i = 0; i < k; i++) {
//             result.add(maxPQ.poll().getKey());
//         }
        
        
//         return result;
    }
}