class Solution {
    List<String> res = new ArrayList<>();
    
    public List<String> restoreIpAddresses(String s) {
        generateIpAddress(new ArrayList<String>(), 0, s);
        return res;
    }
    
    private void generateIpAddress(List<String> path, int start, String s) {
        if (start == s.length() && path.size() == 4) {
            res.add(String.join(".", path)); 
            return;
        }
        for (int i = start; i <= s.length(); i++) {
            String part = s.substring(start, i); // [start, i)
            String remain = s.substring(i);
            
            // if (remain.length() >= 3 * (path.size())) {
            //     continue;
            // }
            
            if (part.length() > 0 && isValid(part)) {
                path.add(part);
                generateIpAddress(path, i, s);
                path.remove(path.size() - 1);
            }
        }
        
        return;
    }
    
    private boolean isValid(String str) {
        // no leading zeros!! 
        // ".01." won't work
        if (str.length() > 1 && str.charAt(0) == '0') {
            return false;
        }
        if (str.length() > 3) {
            return false;
        }
        if (Long.valueOf(str) > (long)255) {
            return false;
        }
        
        return true;
    }
}