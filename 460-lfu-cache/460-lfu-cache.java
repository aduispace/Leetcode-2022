class LFUCache {
    
    int minFreq = 1;
    int capacity = 0;
    Map<Integer, Integer> valMap = new HashMap<>(); // key to val
    Map<Integer, Integer> freqMap = new HashMap<>(); // key to freq
    Map<Integer, LinkedHashSet<Integer>> freqToKeyMap = new HashMap<>(); // freq to keySet
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int res = valMap.getOrDefault(key, -1);
        if (valMap.containsKey(key)) {
            int curFreq = freqMap.getOrDefault(key, 0);
            freqMap.put(key, curFreq + 1);
            updateFreqToKeyMap(key, curFreq);
        }
        
        
        return res;
    }
    
    public void put(int key, int value) {
        // insert a duplicated key would override the old one automatically
        if (valMap.containsKey(key)) {
            valMap.put(key, value);
            int curFreq = freqMap.getOrDefault(key, 0);
            freqMap.put(key, curFreq + 1);
            updateFreqToKeyMap(key, curFreq);
        } else {
            // insert a new key, first check if size reaches capacity
            if (valMap.size() >= this.capacity) {
                if (!freqToKeyMap.containsKey(this.minFreq)) {
                    return;
                }
                LinkedHashSet<Integer> minSet = freqToKeyMap.get(this.minFreq);
                int removeKey = minSet.iterator().next();
                // when remove we need remove from all maps
                minSet.remove(removeKey);
                valMap.remove(removeKey);
                freqMap.remove(removeKey);
            }
            // then update all maps
            valMap.put(key, value);
            int curFreq = freqMap.getOrDefault(key, 0);
            freqMap.put(key, curFreq + 1);
            updateFreqToKeyMap(key, curFreq);
            // reset minFreq
            this.minFreq = 1;
        }
    }
    
    private void updateFreqToKeyMap(int key, int freq) {
        // add to valMap first and update FreqToKeyMap
        // 1. remove cur freq 2. add next freq 
        // if freq == 0, which means this is a brand new key, only add no remove
        if (freq > 0) { 
            LinkedHashSet<Integer> curSet = freqToKeyMap.get(freq);
            curSet.remove(key);
            // update minFreq when currently removed set is empty and it is the minFreq set!! 如果这个 freq 恰好是 minFreq，更新 minFreq
            if (curSet.size() == 0 && freq == this.minFreq) {
                this.minFreq++;
            }
        }
        if (freqToKeyMap.containsKey(freq + 1)) {
            freqToKeyMap.get(freq + 1).add(key);
        } else {
            freqToKeyMap.put(freq + 1, new LinkedHashSet<Integer>(Arrays.asList(key)));
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */