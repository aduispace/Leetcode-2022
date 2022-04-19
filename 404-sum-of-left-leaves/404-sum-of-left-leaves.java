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
    // divide and conquer
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int left = sumOfLeftLeaves(root.left);
        int right = sumOfLeftLeaves(root.right);
        int cur = 0;
        // this is the definition of left leaf
        if (root.left != null && root.left.left == null && root.left.right == null) {
            cur = root.left.val;
        }
        
        return left + right + cur;
    }
}