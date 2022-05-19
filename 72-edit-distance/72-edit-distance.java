class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return getMinMoves(word1, word2, memo);
    }
    
    private int getMinMoves(String word1, String word2, int[][] memo) {
        int m = word1.length();
        int n = word2.length();
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        if (m == 0) return n;
        if (n == 0) return m;
        
        if (word1.charAt(0) == word2.charAt(0)) {
            return getMinMoves(word1.substring(1), word2.substring(1), memo);
        } else {
            int delete = getMinMoves(word1, word2.substring(1), memo);
            int insert = getMinMoves(word1.substring(1), word2, memo);
            int replace = getMinMoves(word1.substring(1), word2.substring(1), memo);
            
            memo[m][n] = 1 + Math.min(delete, Math.min(insert, replace));
        }
        
        return memo[m][n];
    }
}