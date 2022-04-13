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
    // 确定递归函数的参数和返回值：参数就是传入树的根节点，返回就返回这棵树的深度，所以返回值为int类型
    public int maxDepth(TreeNode root) {
        // 确定终止条件：如果为空节点的话，就返回0，表示高度为0
        if (root == null) return 0;
        // 确定单层递归的逻辑和return value
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        
        return Math.max(leftMax, rightMax) + 1;
    }
}

// class Solution {
//     private int maxDepth = 0;
    
//     public int maxDepth(TreeNode root) {
//         if (root == null) return 0;
//         postOrder(root, 1);
        
//         return maxDepth;
//     }
    
//     private void postOrder(TreeNode root, int depth) {
//         if (root == null) return;
//         // both preorder and postorder work for this question 

//         postOrder(root.left, depth + 1);
//         postOrder(root.right, depth + 1);
        
//         maxDepth = Math.max(depth, maxDepth);
//     }
// }