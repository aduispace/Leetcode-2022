class MedianFinder {
    Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b); // minheap, store higher half
    Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // maxheap, store lower half

    public MedianFinder() {
        
    }
    
    public void addNum(int num) { 
        if (!minHeap.isEmpty() && num >= minHeap.peek()) {
            minHeap.offer(num);
        } else if (!minHeap.isEmpty() && num < minHeap.peek()) {
            maxHeap.offer(num);
        } else if (!maxHeap.isEmpty() && num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else if (!maxHeap.isEmpty() && num > maxHeap.peek()) {
            minHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
    }
    
    public double findMedian() {
        this.balanceQueue();
        int totalSize = minHeap.size() + maxHeap.size();
        double result = 0;
        if (totalSize % 2 == 0) {
            double a = (double) minHeap.peek();
            double b = (double) maxHeap.peek();
            result = (a + b) / 2;
        } else if (minHeap.size() > maxHeap.size()) {
            result = (double) minHeap.peek();
        } else {
            result = (double) maxHeap.peek();
        }
        
        return result;
    }
    
    private void balanceQueue() {
        while (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
        while (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll()); 
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */