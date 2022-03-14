class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (int j : nums2) {
            if (map.containsKey(j) && map.get(j) > 0) {
                list.add(j);
                map.put(j, map.get(j) - 1);
            }
        }
        
        // Java 8
        // List<Integer> x = new ArrayList<>(Arrays.asList(7, 9, 13));
        // int[] n = new int[x.size()];
        // Arrays.setAll(n, x::get);
        
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}