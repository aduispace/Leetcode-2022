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
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
                
        oneSideMax(root);
        
        return max;
    }
    
    private int oneSideMax(TreeNode root) {
        if (root == null) return 0;
        
        int leftMax = Math.max(0, oneSideMax(root.left));
        int rightMax = Math.max(0, oneSideMax(root.right));
        int totalMax = leftMax + rightMax + root.val;
        max = Math.max(max, totalMax);
        
        return Math.max(leftMax + root.val, rightMax + root.val);
    }
}