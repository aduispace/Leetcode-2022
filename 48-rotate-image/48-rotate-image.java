class Solution {
    public void rotate(int[][] matrix) {
        // just use reference, no need to return anything
        // 先镜像，再每行反转
        transpose(matrix);
        reverse(matrix);
    }
    
    private void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
    }
    
    private void reverse(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            // 注意两个变量for loop写法
            for (int j = 0, k = n - 1; j <= k; j++, k--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }
    }
}