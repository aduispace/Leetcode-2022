class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
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
    
//     public int[] intersect(int[] nums1, int[] nums2) {
//     if (nums1.length > nums2.length) {
//         return intersect(nums2, nums1);
//     }
//     HashMap<Integer, Integer> m = new HashMap<>();
//     for (int n : nums1) {
//         m.put(n, m.getOrDefault(n, 0) + 1);
//     }
//     int k = 0;
//     for (int n : nums2) {
//         int cnt = m.getOrDefault(n, 0);
//         if (cnt > 0) {
//             nums1[k++] = n;
//             m.put(n, cnt - 1);
//         }
//     }
    // 注意这个用法Arrays.copyOfRange
//     return Arrays.copyOfRange(nums1, 0, k);
// }
}