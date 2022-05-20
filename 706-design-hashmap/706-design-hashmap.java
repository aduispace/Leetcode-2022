class MyHashMap {
    List<Pair<Integer, Integer>>[] map;

    public MyHashMap() {
        map = new LinkedList[1000]; // generics cannot be initialized with <>!!
    }
    
    private int hash(int key) {
        return key % 1000;
    }
    
    public void put(int key, int value) {
        int hashKey = hash(key);
        if (map[hashKey] == null) {
            List<Pair<Integer, Integer>> cur = new LinkedList<>();
            cur.add(new Pair<Integer, Integer>(key, value));
            map[hashKey] = cur;
        } else {
            Pair<Integer, Integer> removed = null;
            for (Pair<Integer, Integer> cur : map[hashKey]) {
                if (cur.getKey() == key) {
                    // cannot remove it here, it throws ConcurrentModificationException
                    removed = cur;
                    break;
                } 
            }
            if (removed != null) {
                map[hashKey].remove(removed);
            }
            map[hashKey].add(new Pair<Integer, Integer>(key, value));
        }
    }
    
    public int get(int key) {
        int hashKey = hash(key);
        if (map[hashKey] == null) {
            return -1;
        } else {
            for (Pair<Integer, Integer> cur : map[hashKey]) {
                if (cur.getKey() == key) {
                    return cur.getValue();
                } 
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int hashKey = hash(key);
        if (map[hashKey] == null) {
            return;
        } else {
            Pair<Integer, Integer> removed = null;
            for (Pair<Integer, Integer> cur : map[hashKey]) {
                if (cur.getKey() == key) {
                    removed = cur;
                    break;
                } 
            }
            if (removed != null) {
                map[hashKey].remove(removed);
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */