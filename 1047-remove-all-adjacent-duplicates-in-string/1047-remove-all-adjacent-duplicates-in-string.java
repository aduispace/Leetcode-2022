class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        for (int i = 0; i < sb.length(); i++) {
            if (i > 0 && sb.charAt(i) == sb.charAt(i - 1)) {
                // stringBuilder delete end here won't overflow, checkout https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html#delete(int,%20int)
                // 用delete无需check end是否超出界限
                sb.delete(i - 1, i + 1);
                i = i - 2;
            }
        }
        
        return sb.toString();
    }
}