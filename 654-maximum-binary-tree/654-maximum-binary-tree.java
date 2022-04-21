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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildSubTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildSubTree(int[] nums, int start, int end) {
        // recursion end condition:
        if (start > end) return null;
        
        int maxVal = Integer.MIN_VALUE;
        int maxPos = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxPos = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = buildSubTree(nums, start, maxPos - 1);
        root.right = buildSubTree(nums, maxPos + 1, end);
        
        return root;
    }
}