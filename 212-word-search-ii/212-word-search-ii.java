class TrieNode {
    // info stored in node
    boolean isWord = false;
    TrieNode[] children = new TrieNode[26];
}

class Trie {
    public TrieNode root;
    
    public Trie(String[] words){
        root = new TrieNode();
        for (String word : words) {
            insert(word);
        }
    }
    
    private void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }
    
    public boolean wordStartsWith(String prefix) {
        TrieNode cur = root;

        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return true;
    }
    
    public boolean isWordExisted(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        
        return cur.isWord;
    }
}

class Solution {
    Set<String> res = new HashSet<>();
    
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        TrieNode root = new Trie(words).root;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                findWord(board, root, visited, new StringBuilder(), i, j);
            }
        }
            
        return new ArrayList<>(res);
    }
    
    private void findWord(char[][] board, TrieNode root, boolean[][] visited, StringBuilder path, int i, int j) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || visited[i][j]) {
            return;
        }
        path.append(board[i][j]);
        
        if (root.children[board[i][j] - 'a'] == null) {
            path.deleteCharAt(path.length() - 1);
            return;
        }
        
        root = root.children[board[i][j] - 'a'];
        if (root.isWord) {
            res.add(path.toString());
        }
        
        visited[i][j] = true;
        
        findWord(board, root, visited, path, i + 1, j);
        findWord(board, root, visited, path, i - 1, j);
        findWord(board, root, visited, path, i, j + 1);
        findWord(board, root, visited, path, i, j - 1);
        
        visited[i][j] = false;
        path.deleteCharAt(path.length() - 1);
        return;
    }

}