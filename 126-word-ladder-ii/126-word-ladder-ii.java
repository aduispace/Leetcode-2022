class Solution {
    List<List<String>> res = new ArrayList<>();
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Map<String, Set<String>> graph = new HashMap<>();
        List<String> path = new ArrayList<>();
        
        buildGraph(graph, beginWord, wordList);
        bfs(visited, graph, beginWord, endWord);
        
        return res;
    }
    
    private void bfs(Set<String> visited, Map<String, Set<String>> graph, String beginWord, String endWord) {
        Queue<List<String>> q = new LinkedList<>();
        boolean isFound = false; // check if we reach endword

        List<String> init = new ArrayList<>();
        init.add(beginWord);
        q.offer(init);
        visited.add(beginWord);
        
        while (!q.isEmpty()) {
            int size = q.size();
            // 记录当前层实际被加进路径的
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> top = q.poll();
                String last = top.get(top.size() - 1);
                // adjacent set or list
                for (String neighbor : graph.getOrDefault(last, new HashSet<>())) {
                    if (!visited.contains(neighbor)) {
                        subVisited.add(neighbor);
                        if (neighbor.equals(endWord)) {
                            top.add(neighbor);
                            res.add(new ArrayList<>(top));
                            isFound = true;
                            top.remove(top.size() - 1);
                        } else {
                            top.add(neighbor);
                            q.offer(new ArrayList<>(top));
                            top.remove(top.size() - 1);
                        }

                    }
                }
            }
            visited.addAll(subVisited);
            if (isFound) {
                break;
            }
        }
    }
    
    private void buildGraph(Map<String, Set<String>> graph, String beginWord, List<String> wordList) {
        for (String word : wordList) {
            if (isAdjacent(beginWord, word)) {
                if (graph.containsKey(beginWord)) {
                    graph.get(beginWord).add(word);
                } else {
                    Set<String> cur = new HashSet<>();
                    cur.add(word);
                    graph.putIfAbsent(beginWord, cur);
                }
            }
        }
        
        for (String a : wordList) {
            for (String b : wordList) {
                if (isAdjacent(a, b)) {
                    if (graph.containsKey(a)) {
                        graph.get(a).add(b);
                    } else {
                        Set<String> cur = new HashSet<>();
                        cur.add(b);
                        graph.putIfAbsent(a, cur);
                    }
                }
            }
        }
    }
    

    private boolean isAdjacent(String a, String b) {
        int res = 0;
        
        for (int i = 0; i < a.length() && i < b.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                res++;
            }
            if (res > 1) {
                return false;
            }
        }
        
        return res == 1;
    }
}

// DFS solution, it would cause time overflow

// class Solution {
//     List<List<String>> res = new ArrayList<>();
    
//     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//         Map<String, Boolean> visited = new HashMap<>();
//         Map<String, Set<String>> graph = new HashMap<>();
//         List<String> path = new ArrayList<>();

//         visited.put(beginWord, false);
//         for (String word : wordList) {
//             visited.put(word, false);
//         }
//         if (!visited.containsKey(endWord)) return new ArrayList<>();
        
//         buildGraph(graph, beginWord, wordList);
//         dfs(visited, graph, path, beginWord, endWord);
        
//         return res;
//     }
    
//     private void dfs(Map<String, Boolean> visited, Map<String, Set<String>> graph, List<String> path, String beginWord, String endWord) {
        
//         if (visited.get(endWord)) {
//             return;
//         }

//         if (!visited.get(beginWord)) {
//             visited.put(beginWord, true);
//             path.add(beginWord);
//             if (beginWord.equals(endWord)) {
//                 int len = path.size();
//                 if (!res.isEmpty()) {
//                     if (res.get(0).size() > len) {
//                         res.clear();
//                         List<String> cur = new ArrayList<>(path);
//                         res.add(cur);
//                     } else if (res.get(0).size() == len) {
//                         res.add(new ArrayList<>(path));
//                     }
//                 } else {
//                     res.add(new ArrayList<>(path));
//                 }
//             }
            
//             for (String next : graph.getOrDefault(beginWord, new HashSet<>())) {
//                 dfs(visited, graph, path, next, endWord);
//             }
            
//             visited.put(beginWord, false);
//             path.remove(path.size() - 1);
//         }
//     }
    
//     private void buildGraph(Map<String, Set<String>> graph, String beginWord, List<String> wordList) {
//         for (String word : wordList) {
//             if (isAdjacent(beginWord, word)) {
//                 if (graph.containsKey(beginWord)) {
//                     graph.get(beginWord).add(word);
//                 } else {
//                     Set<String> cur = new HashSet<>();
//                     cur.add(word);
//                     graph.putIfAbsent(beginWord, cur);
//                 }
//             }
//         }
        
//         for (String a : wordList) {
//             for (String b : wordList) {
//                 if (isAdjacent(a, b)) {
//                     if (graph.containsKey(a)) {
//                         graph.get(a).add(b);
//                     } else {
//                         Set<String> cur = new HashSet<>();
//                         cur.add(b);
//                         graph.putIfAbsent(a, cur);
//                     }
//                 }
//             }
//         }
//     }
    

//     private boolean isAdjacent(String a, String b) {
//         int res = 0;
        
//         for (int i = 0; i < a.length() && i < b.length(); i++) {
//             if (a.charAt(i) != b.charAt(i)) {
//                 res++;
//             }
//             if (res > 1) {
//                 return false;
//             }
//         }
        
//         return res == 1;
//     }
// }