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
        return searchUtil(word, root);
    }
    
    public boolean searchUtil(String word, TrieNode start) {
        if (word == null || word.length() == 0) {
            return start.isWord;
        }
        
        char c = word.charAt(0);
        if (c != '.') {
            if (start.children[c - 'a'] == null) {
                return false;
            } else {
                return searchUtil(word.substring(1), start.children[c - 'a']);
            }
        } else {
            for (int j = 0; j < start.children.length; j++) {
                if (start.children[j] != null && searchUtil(word.substring(1), start.children[j])) {
                    // 注意这里不能直接return searchUtil(...), 因为有可能直接return false，但要整个children run完才知道有没有valid！！！
                
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