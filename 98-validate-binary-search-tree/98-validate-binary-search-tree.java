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
    private long prev = Long.MIN_VALUE;
    private boolean res = true;
    public boolean isValidBST(TreeNode root) {
        traverse(root);
        return res;
    }
    
    private void traverse(TreeNode root) {
        if (root == null) return;
        
        traverse(root.left);
        if ((long) root.val <= prev) {
            res = false;
            return;
        } else {
            prev = (long) root.val;
        }
        traverse(root.right);
        
        return;
    }
}