class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // m = 3, n = 4
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m*n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // treat this 2D array as 1D and this `x = mid / n, y = mid % n` is the key!!
            int x = mid / n, y = mid % n; 
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                right = mid - 1; 
            } else if (matrix[x][y] < target) {
                left = mid + 1;
            }
        }
        return false;
    }
}