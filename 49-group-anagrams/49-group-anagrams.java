class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
//         Time Complexity: O(NKlogK), where NN is the length of strs, and KK is the maximum length of a string in strs. The outer loop has complexity O(N)O(N) as we iterate through each string. Then, we sort each string in O(K \log K)O(KlogK) time.

// Space Complexity: O(NK)O(NK), the total information content stored in ans.
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
    // 优化可以用counting sort：https://www.runoob.com/w3cnote/counting-sort.html
    private String sortString(String s) {
        // O(nlogN)
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        // careful how convert array to string
        return String.valueOf(arr);
    }
}