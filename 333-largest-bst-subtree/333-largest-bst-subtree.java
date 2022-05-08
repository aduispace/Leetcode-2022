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
    int res = 0;
    
    public int largestBSTSubtree(TreeNode root) {
        findBST(root);
        
        return res;
    }
    
    // return [current tree Max, current tree Min, cur tree size]
    private int[] findBST(TreeNode root) {
        // valid case for null, null is a BST
        if (root == null) return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        
        int[] left = findBST(root.left);
        int[] right = findBST(root.right);
        
        // invalid case if left or right is null
        if (left == null || right == null) return null;
        
        if (root.val > left[0] && root.val < right[1]) {
            int size = left[2] + right[2] + 1;
            res = Math.max(res, size);
            int max = Math.max(root.val, right[0]);
            int min = Math.min(root.val, left[1]);
            return new int[]{max, min, size};
        }
        
        return null;
    }
}