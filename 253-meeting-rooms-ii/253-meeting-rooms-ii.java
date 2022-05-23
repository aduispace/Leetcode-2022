class Solution {
    public int minMeetingRooms(int[][] intervals) {
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
}