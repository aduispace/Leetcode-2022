class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        
        // fill with -1 cuz move could be 0
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
            int delete = getMinMoves(word1.substring(1), word2, memo); // delete extra char in word1, so compare next on word1.
            int insert = getMinMoves(word1, word2.substring(1), memo); // insert in word1 with extra char at word2, so compare next on word2.
            int replace = getMinMoves(word1.substring(1), word2.substring(1), memo);
            
            // add one move
            memo[m][n] = 1 + Math.min(delete, Math.min(insert, replace));
        }
        
        return memo[m][n];
    }
}