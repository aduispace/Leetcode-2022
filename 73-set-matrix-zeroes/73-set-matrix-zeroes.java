class Solution {
    public void setZeroes(int[][] matrix) {
        
        
        // time: O(NxM)
        // space: O(M+N)
        Set<Integer> columns = new HashSet<>();
        Set<Integer> rows = new HashSet<>();
        int m = matrix.length, n = matrix[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        
        for (int i : rows) {
            Arrays.fill(matrix[i], 0);
        }
        
        for (int j : columns) {
            for (int i = 0; i < m; i++) {
                matrix[i][j] = 0;
            }
        }
        
        // optimized with O(1) space, use first row and column as markers:
        // https://leetcode.com/problems/set-matrix-zeroes/discuss/26014/Any-shorter-O(1)-space-solution
        
    }
}