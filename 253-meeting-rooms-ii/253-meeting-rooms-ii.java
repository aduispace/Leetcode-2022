class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // O(NlogN)
        // sweep line: project intervals to x axis -> sort start and end array -> meeting start, count++, meeting end, count--
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        int res = 0;
        int curCount = 0, i = 0, j = 0;
        
        while (i < intervals.length && j < intervals.length) {
            if (start[i] < end[j]) {
                curCount++;
                i++;
            } else {
                // if start[i] == end[j], 相连不冲突，不需要多加一个meeting room
                curCount--;
                j++;
            }
            res = Math.max(res, curCount);
        }
        
        return res;
    }
    /** 
    也可以用pq做
    
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals,(a,b)->(a.start-b.start));
        PriorityQueue<Interval> pq=new PriorityQueue<>((a,b)->(a.end-b.end));
        for(Interval i:intervals){
            if(!pq.isEmpty()&&pq.peek().end<=i.start){ // we found a start[prev] < start[i] and end[prev] < start[i], it won't cause any conflicts, just poll out
                pq.poll();
            }
            pq.add(i);
        }
        return pq.size();
    }
    **/
}