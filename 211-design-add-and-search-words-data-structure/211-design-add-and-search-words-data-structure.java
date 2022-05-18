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
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] chs, int k, TrieNode node) {
        if (k == chs.length) {
            return node.isWord;
        }
        if (chs[k] == '.') {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null && match(chs, k + 1, node.children[i])) {
                    return true;
                }
            }
        } else {
            return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
        }
        return false;
    }
    

//     public boolean search(String word) {
//         return searchUtil(word, 0, root);
//     }
    
//     public boolean searchUtil(String word, int i, TrieNode start) {
//         if (i >= word.length()) {
//             return start.isWord;
//         }
        
//         char c = word.charAt(i);
//         if (c != '.') {
//             // if (start.children[c - ' '] == null) {
//             //     return false;
//             // } else {
//             //     return searchUtil(word, i + 1, start.children[c - ' ']);
//             // }
//             return start.children[c - ' '] != null && searchUtil(word, i + 1, start.children[c - ' ']);
//         } else {
//             for (int j = 0; j < start.children.length; j++) {
//                 if (start.children[j] != null) {
//                     return searchUtil(word, i + 1, start.children[j]);
//                 }
//             }
//         }
        
//         return false;
//     }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */