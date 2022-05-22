class Solution {
    public int[][] merge(int[][] intervals) {
        // 起点升序，终点降序，排序完一半可以分三种情况讨论
        List<int[]> res = new ArrayList<>();
        
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];
            if (nextStart <= end) {
                // [    ]
                //  [ ]
                if (nextEnd <= end) {
                    continue;
                } else {
                    // [   ]
                    //   [   ]
                    end = nextEnd;
                }
            } else {
                // [   ]
                //       [   ]
                res.add(new int[]{start, end});
                start = nextStart;
                end = nextEnd;
            }
        }
        
        // edge case： 最后一个res可能没加入结果！！
        if (res.size() == 0 || res.get(res.size() - 1)[0] != start) {
            res.add(new int[]{start, end});
        } 
        
        int[][] resArray = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        
        return resArray;
    }
}