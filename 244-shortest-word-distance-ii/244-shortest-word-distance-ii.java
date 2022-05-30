class WordDistance {
    // ["practice", "makes", "perfect", "coding", "makes"]
    Map<String, List<Integer>> map = new HashMap<>();
    
    
    public WordDistance(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            if (map.containsKey(wordsDict[i])) {
                map.get(wordsDict[i]).add(i);
            } else {
                map.put(wordsDict[i], new ArrayList<Integer>(Arrays.asList(i)));
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        if (!map.containsKey(word1) || !map.containsKey(word2)) {
            return -1;
        }
        
        List<Integer> list1 = map.get(word1); // [1, 4, 5]
        List<Integer> list2 = map.get(word2); // [3, 8]
        
        int i = 0, j = 0;
        int res = Integer.MAX_VALUE;
        while (i < list1.size() && j < list2.size()) {
            int first = list1.get(i);
            int second = list2.get(j);
            if (first < second) {
                res = Math.min(res, second - first);
                i++;
            } else {
                res = Math.min(res, first - second);
                j++;
            }
        }
        
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */