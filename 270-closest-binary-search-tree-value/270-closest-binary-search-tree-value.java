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
    double min = Double.MAX_VALUE;
    int res;
    
    public int closestValue(TreeNode root, double target) {
        traverse(root, target);
        return res;
    }
    
    private void traverse(TreeNode root, double target) {
        if (root == null) return;
        traverse(root.left, target);
        if (Math.abs(target - (double) root.val) < min) {
            min = Math.abs(target - (double) root.val);
            res = root.val;
        }
        traverse(root.right, target);
        
        return;
    }
}