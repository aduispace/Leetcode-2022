class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegrees = new HashMap<>();
        if (!buildGraph(words, graph, indegrees)) return "";
        
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        for (char ch : indegrees.keySet()) {
            if (indegrees.get(ch) == 0) {
                q.offer(ch);
            }
        }
        
        while (!q.isEmpty()) {
            char cur = q.poll();
            count++;
            sb.append(cur);
            
            for (char ch : graph.getOrDefault(cur, new HashSet<>())) {
                int minus = indegrees.get(ch) - 1;
                indegrees.put(ch, minus);
                if (indegrees.get(ch) == 0) {
                    q.offer(ch);
                }
            }
        }
                 
        return count == indegrees.size() ? sb.toString() : "";          
    }
    
    private boolean buildGraph(String[] words, Map<Character, Set<Character>> graph, Map<Character, Integer> indegrees) {
        // initialize graph and indegrees
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (!graph.containsKey(ch)) {
                    graph.put(ch, new HashSet<Character>());
                    indegrees.put(ch, 0);
                }
            }
        }
        
        for (int i = 1; i < words.length; i++) {
            char[] word1 = words[i - 1].toCharArray(), word2 = words[i].toCharArray();
            if (words[i - 1].startsWith(words[i]) && word1.length > word2.length) {
                return false;
            }
            int len = Math.min(word1.length, word2.length);
            for (int j = 0; j < len; j++) {
                if (word1[j] != word2[j]) {
                    int plus = graph.get(word1[j]).contains(word2[j]) ? indegrees.get(word2[j]) : indegrees.get(word2[j]) + 1;
                    graph.get(word1[j]).add(word2[j]);
                    indegrees.put(word2[j], plus);
                    break;
                }
            }
        }
        
        return true;
    }
}