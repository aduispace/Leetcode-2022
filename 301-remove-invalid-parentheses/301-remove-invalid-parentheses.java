class Solution {
    List<String> res = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            left += c == '(' ? 1 : 0;
            if (left == 0) {
                right += c == ')' ? 1 : 0;
            } else {
                left -= c == ')' ? 1 : 0;
            }
        }
        getValidString(left, right, 0, s);
        return res;
    }
    
    private void getValidString(int left, int right, int start, String s) {
        if (left == 0 && right == 0) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            // 在回溯的同一个level，（）），去掉前后任意一个）得到的结果都一样，所以需要跳过同样的以deduplicate
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            } 
            
            if (left > 0 && s.charAt(i) == '(') {
                getValidString(left - 1, right, i, s.substring(0, i) + s.substring(i + 1));
            }
            
            if (right > 0 && s.charAt(i) == ')') {
                getValidString(left, right - 1, i, s.substring(0, i) + s.substring(i + 1));
            }
        }
        
        return;
    }
        
    private boolean isValid(String s) {
        int leftCount = 0, rightCount = 0;
        for (char c : s.toCharArray()) {
            if (rightCount > leftCount) {
                return false;
            }
            if (c == '(') leftCount++;
            if (c == ')') rightCount++;
        }
        
        return leftCount == rightCount;
    }     
}