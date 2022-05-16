class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        
        for (String path : paths) {
            String[] info = path.split(" ");
            String actualPath = info[0];
            if (info.length <= 1) {
                continue;
            }
            for (int i = 1; i < info.length; i++) {
                String key = getStringFromParenthese(info[i]);
                String val = actualPath + "/" + info[i].substring(0, info[i].indexOf('('));
                if (map.containsKey(key)) {
                    map.get(key).add(val);
                } else {
                    List<String> cur = new ArrayList<>();
                    cur.add(val);
                    map.put(key, cur);
                }
            }
        }
        
        for (List<String> dup : map.values()) {
            if (dup.size() > 1) {
                res.add(dup);
            }
        }
        
        return res;
    }
    
    private String getStringFromParenthese(String s) {
        return s.substring(s.indexOf('(') + 1, s.indexOf(')'));
    }
}