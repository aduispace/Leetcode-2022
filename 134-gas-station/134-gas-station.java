class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
//         The reason why I think this works:
// 1, if sum of gas is more than sum of cost, then there must be a solution. And the question guaranteed that the solution is unique(The first one I found is the right one).
// 2, The tank should never be negative, so restart whenever there is a negative number.
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