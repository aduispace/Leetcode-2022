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
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        reverseInorderTraverse(root);
        return root;
    }
    
    private void reverseInorderTraverse(TreeNode root) {
        if (root == null) return;
        reverseInorderTraverse(root.right);
        // 加的是之前节点的累加和
        sum += root.val;
        root.val = sum;
        reverseInorderTraverse(root.left);
        
        return;
    }
}