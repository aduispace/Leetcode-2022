public class TrieNode {
    private final int R = 26;
    boolean isWord = false;
    char val; 
    TrieNode[] children = new TrieNode[R];
    public TrieNode(){}
}

class Trie {
    public TrieNode root;

    public Trie() {
        // just need to instaniate a root
        root = new TrieNode();
    }

    public void insert(String word) {
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
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            // move pointer to next
            cur = cur.children[c - 'a'];
        }
        
        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            // move pointer to next
            cur = cur.children[c - 'a'];
        }
        // prefix includes itself, "ab" prefix is "ab" or "a"
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */