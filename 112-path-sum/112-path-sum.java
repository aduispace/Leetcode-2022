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
    private boolean isPathExisted = false;
    private int sum = 0;
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            sum += root.val;
            if (sum == targetSum) {
                return true;
            }
            sum -= root.val;
        }
        boolean left = false;
        boolean right = false;
        if (root.left != null) {
            sum += root.val;
            left = hasPathSum(root.left, targetSum);
            sum -= root.val;
        }
        if (root.right != null) {
            sum += root.val;
            right = hasPathSum(root.right, targetSum);
            sum -= root.val;
        }
        
        return left || right;
    }
}