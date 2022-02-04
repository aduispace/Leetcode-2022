class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // O(NlogN)
        Arrays.sort(piles);
        int left = 1, right = piles[piles.length - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (ifFinishedInTime(piles, mid, h)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private boolean ifFinishedInTime(int[] piles, int k, int h) {
        int totalHours = 0;
        for (int i : piles) {
            totalHours += i % k == 0 ? i / k : i / k + 1;
        }
        return totalHours <= h;
    }
}