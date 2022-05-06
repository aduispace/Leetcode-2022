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
    int res;
    int cur = 0; 
    
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }
    
    // 这里不能带着cur int进traverse，因为int不是reference type而是primitive type
    private void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.left, k);
        cur++;
        if (cur == k) {
            res = root.val;
        }
        traverse(root.right, k);
        
        return;
    }
}