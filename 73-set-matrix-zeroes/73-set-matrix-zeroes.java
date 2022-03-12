class Solution {
    public void setZeroes(int[][] matrix) {
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
        
        
    }
}