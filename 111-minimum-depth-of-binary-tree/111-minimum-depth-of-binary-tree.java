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
    private int minDepth = Integer.MAX_VALUE;
    
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 1);
        
        return minDepth;
    }
    
    private void dfs(TreeNode root, int depth) {
        // 返回条件
        if (root == null) {
            return;
        }
        // 每次更新mindepth都在leaf node，这里是判断当前是不是叶子结点，然后go left and go right
        if (root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, depth);
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
        return;
    }
}