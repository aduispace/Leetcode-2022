class HitCounter {
    Deque<Integer> queue = new ArrayDeque<>();
    public HitCounter() {
        
    }
    // O(1)
    public void hit(int timestamp) {
        queue.offerFirst(timestamp);
    }
    
    // O(N)
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peekLast() >= 300) {
            queue.pollLast();
        }
        
        return queue.isEmpty() ? 0 : queue.size();
    }
}

/** follow-up1: What if the number of hits per second could be huge? Does your design scale? 每个timestamp hit 很大：If we encounter the hit for the same timestamp, instead of appending a new entry in the deque, we simply increment the count of the latest timestamp.
**/

// class HitCounter {

//     private int total;
//     private Deque<Pair<Integer, Integer>> hits; 

//     /** Initialize your data structure here. */
//     public HitCounter() {
//         // Initialize total to 0
//         this.total = 0;
//         this.hits = new LinkedList<Pair<Integer, Integer>>();
//     }
    
//     /** Record a hit.
//         @param timestamp - The current timestamp (in seconds granularity). */
//     public void hit(int timestamp) {
//         if (this.hits.isEmpty() || this.hits.getLast().getKey() != timestamp) {
//             // Insert the new timestamp with count = 1
//             this.hits.add(new Pair<Integer, Integer>(timestamp, 1));
//         } else {
//             // Update the count of latest timestamp by incrementing the count by 1

//             // Obtain the current count of the latest timestamp 
//             int prevCount = this.hits.getLast().getValue();
//             // Remove the last pair of (timestamp, count) from the deque
//             this.hits.removeLast();
//             // Insert a new pair of (timestamp, updated count) in the deque
//             this.hits.add(new Pair<Integer, Integer>(timestamp, prevCount + 1));
//         }
//         // Increment total
//         this.total++;
//     }
    
//     /** Return the number of hits in the past 5 minutes.
//         @param timestamp - The current timestamp (in seconds granularity). */
//     public int getHits(int timestamp) {
//         while (!this.hits.isEmpty()) {
//             int diff = timestamp - this.hits.getFirst().getKey();
//             if (diff >= 300) {
//                 // Decrement total by the count of the oldest timestamp
//                 this.total -= this.hits.getFirst().getValue();
//                 this.hits.removeFirst();
//             }
//             else break;
//         }
//         return this.total;
//     }
// }

/** follow-up2: What if we want to keep all the elements and we need to check back: use an arrayList and a start pointer that has 300 seconds distance with lastest
**/

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */