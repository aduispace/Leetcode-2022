class Solution {
    public int minimumDeletions(String s) {
        // [aababbab] -> [b: 3, a: 2]
        // [bbaaaaabb] -> [b: 2, ]
        int res = 0;
        int numOfB = 0;
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                if (numOfB == 0) {
                    continue;
                } else {
                    res++;
                    numOfB--;
                }
            }
            
            if (c == 'b') {
                numOfB++;
            }
        }
        
        return res;
    }
}