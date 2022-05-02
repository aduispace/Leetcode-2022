class Solution {
    // Time O(E + V), e for edges, V for vertices, visit all Vs and for each V we will visit its edges
    // Space O(E+V)
    

    int[] indegrees;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        indegrees = new int[numCourses];
        Map<Integer, List<Integer>> graph = buildGraph(prerequisites, indegrees);
        Queue<Integer> q = new LinkedList<>();
        
        // initialize the queue with indegree is 0, then do the BFS
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        } 
        
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // each vertex in graph is processed, count++
                int cur = q.poll();
                count++;
                for (int to : graph.getOrDefault(cur, new ArrayList<Integer>())) {
                    // indegrees[cur]--;
                    if (--indegrees[to] == 0) {
                        q.offer(to);
                    }
                }
            }
        }
        
        return count == numCourses;
    }
    
    private Map<Integer, List<Integer>> buildGraph(int[][] prerequisites, int[] indegrees) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] course : prerequisites) {
            int from = course[1], to = course[0];
            indegrees[to]++;
            if (graph.containsKey(from)) {
                graph.get(from).add(to);
            } else {
                graph.put(from, new ArrayList<Integer>(Arrays.asList(to)));
            }
        }
        return graph;
    }
}