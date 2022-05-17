// 记住TrieNode的定义:

/***

class TrieNode {

    // R links to node children
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}

***/

public class TrieNode {
    private final int R = 26;
    boolean isWord = false;
    char val; 
    TrieNode[] children = new TrieNode[R];
    public TrieNode(){}
}

// 字符存在path上(child node是否存在)，具体信息存在node里：
// 这里要特别注意，TrieNode节点本身只存储val字段，并没有一个字段来存储字符，字符是通过子节点在父节点的children数组中的索引确定的。

// 形象理解就是，Trie 树用「树枝」存储字符串（键），用「节点」存储字符串（键）对应的数据（值）。所以我在图中把字符标在树枝，键对应的值val标在节点上：

class Trie {
    private TrieNode root;

    public Trie() {
        // just need to instaniate a root
        root = new TrieNode();
    }
    
    // Time: O(m), m is word length

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
    
    // Time: O(m), m is word length

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
    
    // Time: O(m), m is word length

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