class RandomizedSet {
    // 题意：不会有重复的val
    List<Integer> randomizedSet = new ArrayList<>(); // val 
    Map<Integer, Integer> map = new HashMap<>(); // val to index

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, randomizedSet.size());
        randomizedSet.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int lastVal = randomizedSet.get(randomizedSet.size() - 1);
        // update map and set for lastVal for its new position
        map.put(lastVal, index);
        randomizedSet.remove(index);
        randomizedSet.add(index, lastVal);
        
        // remove from map and set
        map.remove(val);
        randomizedSet.remove(randomizedSet.size() - 1);
        
        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        return randomizedSet.get(rand.nextInt(randomizedSet.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */