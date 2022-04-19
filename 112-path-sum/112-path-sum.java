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
    // divide and conquer: postOrder! 当前问题是子问题的合并
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            return true;
        }
        
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}

// class Solution {
    
    
//     /* 解法二、遍历二叉树的思路 */

//     // traverse and backtrack: 
//     private boolean isPathExisted = false;
//     private int sum = 0;
    
//     public boolean hasPathSum(TreeNode root, int targetSum) {
//         if (root == null) return false;
//         sum += root.val;
//         if (root.left == null && root.right == null) {
//             if (sum == targetSum) {
//                 return true;
//             }
            
//         }
//         boolean left = false;
//         boolean right = false;
//         if (root.left != null) {
//             left = hasPathSum(root.left, targetSum);
//         }
//         if (root.right != null) {
//             right = hasPathSum(root.right, targetSum);
//         }
//         sum -= root.val;
        
//         return left || right;
//     }
// }