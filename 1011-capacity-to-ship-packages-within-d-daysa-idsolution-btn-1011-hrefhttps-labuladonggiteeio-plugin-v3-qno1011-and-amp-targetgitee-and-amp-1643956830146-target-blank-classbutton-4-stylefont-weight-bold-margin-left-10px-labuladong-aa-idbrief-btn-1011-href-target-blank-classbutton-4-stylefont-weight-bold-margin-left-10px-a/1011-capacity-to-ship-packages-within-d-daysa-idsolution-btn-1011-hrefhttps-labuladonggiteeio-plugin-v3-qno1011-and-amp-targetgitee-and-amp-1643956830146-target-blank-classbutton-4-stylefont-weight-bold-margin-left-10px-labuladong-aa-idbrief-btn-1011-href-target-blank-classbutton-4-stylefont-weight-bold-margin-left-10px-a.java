class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int i : weights) {
            // most important part: left bound >= max of weight array! right bound <= sum
            left = Math.max(i, left);
            right += i;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isShippedInTime(weights, days, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private boolean isShippedInTime(int[] weights, int days, int capacity) {
        int eachShipLoadSum = 0;
        for (int i : weights) {
            if (eachShipLoadSum + i > capacity) {
                days -= 1;
                if (days == 0) return false;
                // the load for that day would be moved to next day so eachShipLoadSum = i;
                eachShipLoadSum = i;
            } else {
                eachShipLoadSum += i;
            }
        }
        return true;
    }
}