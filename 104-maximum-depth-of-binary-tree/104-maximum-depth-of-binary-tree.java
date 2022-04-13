/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxDepth = 0;
    
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        postOrder(root, 1);
        
        return maxDepth;
    }
    
    private void postOrder(TreeNode root, int depth) {
        if (root == null) return;
        postOrder(root.left, depth + 1);
        postOrder(root.right, depth + 1);
        
        maxDepth = Math.max(depth, maxDepth);
    }
}