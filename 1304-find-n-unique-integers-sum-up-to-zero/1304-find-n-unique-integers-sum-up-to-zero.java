class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        if (n % 2 == 0) {
            for (int i = 1; i <= n / 2; i++) {
                res[n - i] = -i;
                res[i - 1] = i;
            }
        } else {
            res[0] = 0;
            for (int i = 1; i <= n / 2; i++) {
                res[n - i] = -i;
                res[i - 1] = i;
            }
        }
        
        return res;
    }
}