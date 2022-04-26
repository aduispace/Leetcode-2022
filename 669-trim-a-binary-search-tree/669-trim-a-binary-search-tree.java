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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return root;
        if (root.val < low) {
            // 直接返回 root.right
            // 等于删除 root 以及 root 的左子树
            root = trimBST(root.right, low, high);
        } else if (root.val > high) {
            // 直接返回 root.left
            // 等于删除 root 以及 root 的右子树
            root = trimBST(root.left, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        
        return root;
    }
}