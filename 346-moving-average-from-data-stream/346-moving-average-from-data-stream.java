class MovingAverage {
    Deque<Integer> dq = new ArrayDeque<>();
    int sum = 0;
    int windowSize = 0;

    public MovingAverage(int size) {
        windowSize = size;
    }
    
    // O(1)
    public double next(int val) {
        double res = 0.0;
        dq.offerLast(val);
        int curSize = dq.size();
        if (curSize <= windowSize) {
            sum += val;
            res = (double) sum / curSize;
        } else {
            sum = sum + val - dq.pollFirst();
            res = (double) sum / windowSize;
        }
        
        return res;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */