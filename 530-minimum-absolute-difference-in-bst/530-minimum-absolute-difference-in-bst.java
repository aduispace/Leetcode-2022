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
    // inorder traverse
    int minDiff = Integer.MAX_VALUE;
    Integer pre = null;
    
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return minDiff;
    }
    
    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        if (pre == null) {
            pre = root.val;
        } else {
            minDiff = Math.min(root.val - pre, minDiff);
            pre = root.val;
        }
        traverse(root.right);
        
        return;
    }
}