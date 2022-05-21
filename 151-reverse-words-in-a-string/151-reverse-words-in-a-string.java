class Solution {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        List<String> list = new ArrayList<>();
        
        for (String str : strs) {
            if (str.trim().length() != 0) {
                list.add(str.trim());
            }
        }
        
        int start = 0, end = list.size() - 1;
        while (start < end) {
            // swap
            String a = list.get(start);
            String b = list.get(end);
            list.set(start, b);
            list.set(end, a);
            start++;
            end--;
        }
        
        return String.join(" ", list);
    }
    
    
}