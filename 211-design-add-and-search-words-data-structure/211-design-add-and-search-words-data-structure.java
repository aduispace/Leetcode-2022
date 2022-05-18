class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
    char val;
    public TrieNode(){}
}

class WordDictionary {
    
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        } 
        cur.isWord = true;
    }
    

    public boolean search(String word) {
        return searchUtil(word, 0, root);
    }
    
    public boolean searchUtil(String word, int i, TrieNode start) {
        if (i >= word.length()) {
            return start.isWord;
        }
        
        char c = word.charAt(i);
        if (c != '.') {
            return start.children[c - 'a'] != null && searchUtil(word, i + 1, start.children[c - 'a']);
        } else {
            for (int j = 0; j < start.children.length; j++) {
                if (start.children[j] != null && searchUtil(word, i + 1, start.children[j])) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */