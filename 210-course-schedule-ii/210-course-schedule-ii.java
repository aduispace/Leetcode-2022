class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // adjacent lists to reprensent graphs
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegrees = new int[numCourses];
        
        for (int[] course : prerequisites) {
            int from = course[1], to = course[0];
            indegrees[to]++;
            if (graph.containsKey(from)) {
                graph.get(from).add(to);
            } else {
                graph.put(from, new ArrayList<>(Arrays.asList(to)));
            }
        }
        
        // BFS, initialize the queue
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }
        
        int count = 0;
        // the BFS processed sequence is the topologically sorted!!
        int[] res = new int[numCourses];
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                res[count] = cur;
                count++;
                // graph might not have outbound verties!!
                for (int to : graph.getOrDefault(cur, new ArrayList<>())) {
                    if (--indegrees[to] == 0) {
                        q.offer(to);
                    }
                }
            }
        }
        
        return count == numCourses ? res : new int[]{};
    }
    
}