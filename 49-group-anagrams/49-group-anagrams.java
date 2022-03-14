class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String sortStr = sortString(s);
            List<String> temp = map.getOrDefault(sortStr, new ArrayList<String>());
            temp.add(s);
            map.put(sortStr, temp);
        }
        
        res.addAll(map.values());
        
        return res;
    }
    
    private String sortString(String s) {
        // O(nlogN)
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
}