class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, upper = 0, lower = n - 1;
        int num = 1;
        while (num <= n * n) {
            if (upper <= lower) {
                for (int i = left; i <= right; i++) {
                    res[upper][i] = num;
                    num++;
                }
            }
            upper++;
 
            if (right >= left) {
                for (int i = upper; i <= lower; i++) {
                    res[i][right] = num;
                    num++;
                }
            }
            right--;

            if (upper <= lower) {
                for (int i = right; i >= left; i--) {
                    res[lower][i] = num;
                    num++;
                }
            }
            lower--;
            
            if (right >= left) {
                for (int i = lower; i >= upper; i--) {
                    res[i][left] = num;
                    num++;
                }
            }
            left++;            
        }
        
        return res;
    }
}