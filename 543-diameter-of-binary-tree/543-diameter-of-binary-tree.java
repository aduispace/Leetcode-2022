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
    // 每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和
    // 可以不经过根节点！！！
    private int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        maxDepth(root);
        return maxDiameter;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        maxDiameter = Math.max(leftDepth + rightDepth, maxDiameter);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
}