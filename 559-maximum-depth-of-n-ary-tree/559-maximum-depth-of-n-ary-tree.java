/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int curMax = 0;
        for (Node node : root.children) {
            curMax = Math.max(curMax, maxDepth(node));
        }
        
        return curMax + 1;
    }
}