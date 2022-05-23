class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int tank = 0;
        int start = 0;
        
        // check if there's a solution
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
        }
        
        if (total < 0) {
            return -1;
        }
        // start from 0, see could we go from i to j
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i]; // going to i + 1
            // reset tank and start
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        
        return start;
    }
}