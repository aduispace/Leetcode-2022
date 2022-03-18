class LRUCache {
    int capacity = 0;
    Map<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        int val = cache.get(key);
        this.makeKeyMostRecently(key, val);
        return val;
    }
    
    public void put(int key, int value) {
        this.makeKeyMostRecently(key, value);
        if (cache.size() > capacity) {
            // iterator starts from the first inserted element, so first next() would be the least used element
            int i = cache.keySet().iterator().next();
            cache.remove(i);
        }
    }
    
    private void makeKeyMostRecently(int key, int val) {
        if (cache.containsKey(key)) {
            // if key exists, it would be just an update
            cache.remove(key);
        }
        cache.put(key, val);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */