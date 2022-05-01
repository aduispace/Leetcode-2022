class Solution {
    List<String> res = new ArrayList<>();
    
    // Time: O(2^N)
    
    // Space: O(N) callstack for backtracking
    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), n, n);
        
        return res;
    }
    
    private void backtrack(StringBuilder path, int left, int right) {
        // prune in base cases: 
        if (left == 0 && right == 0) {
            res.add(path.toString());
            return;
        } else if (left > right) {
            // 剩下的右边必须>=左边parenthesis
            return;
        } else if (left < 0 || right < 0) {
            return;
        }
        
        path.append("(");
        backtrack(path, left - 1, right);
        path.setLength(path.length() - 1);
        
        path.append(")");
        backtrack(path, left, right - 1);
        path.setLength(path.length() - 1);
        
        return;
    }
}