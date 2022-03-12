class HitCounter {
    Deque<Integer> queue = new ArrayDeque<>();
    public HitCounter() {
        
    }
    
    public void hit(int timestamp) {
        queue.offerFirst(timestamp);
    }
    
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peekLast() >= 300) {
            queue.pollLast();
        }
        
        return queue.isEmpty() ? 0 : queue.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */