class Solution {
    public int[][] highFive(int[][] items) {
        // Queue<int[][]> lowerQueue = new PriorityQueue<>();
        List<int[]> result = new ArrayList<>();

        Arrays.sort(items, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });
        
        int id = items[0][0];
        int sum = 0;
        int i = 5;
        
        for (int[] item : items) {
            if (id != item[0]) {
                id = item[0];
                sum = 0;
                i = 5;
            }
            i--;
            if (i > 0) {
                sum += item[1];
            } else if (i == 0) {
                sum += item[1];   
                int[] arr = new int[]{id, sum / 5};
                result.add(arr);
            }
        }
        
        int[][] res = new int[result.size()][2];
        for (int j = 0; j < result.size(); j++) {
            res[j] = result.get(j);
        }
        
        return res;
        
    }
}