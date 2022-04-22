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
    // 1. 不能单纯的比较左节点小于中间节点，右节点大于中间节点就完事了, 每个node都要满足条件
    // 2. 边界条件 int min-value可能溢出
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