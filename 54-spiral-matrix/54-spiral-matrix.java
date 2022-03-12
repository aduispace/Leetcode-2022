class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int upper = 0, left = 0, lower = matrix.length - 1, right = matrix[0].length - 1;
        int total = matrix.length * matrix[0].length;
        while (res.size() < total) {
            // iterate upper bound from left to right
            if (upper <= lower) {
                for (int i = left; i <= right; i++) {
                    // left to right is for matrix second []
                    res.add(matrix[upper][i]);
                }
            }
            // shrink boundary
            upper++;
            // iterate right bound from upper to lower
            if (right >= left) {
                for (int i = upper; i <= lower; i++) {
                    // upper to lower is for matrix first []
                    res.add(matrix[i][right]);
                }
            }
            // shrink boundary
            right--;
            // iterate lower bound from right to left            
            if (lower >= upper) {
                for (int i = right; i >= left; i--) {
                    // right to left is for matrix second []
                    res.add(matrix[lower][i]);
                }
            }
            // shrink boundary
            lower--;
            // iterate left bound from lower to upper
            if (left <= right) {
                for (int i = lower; i >= upper; i--) {
                    // lower to upper is for matrix first []
                    res.add(matrix[i][left]);
                }
            }
            // shrink boundary
            left++;
        }
        
        return res;
    }
}