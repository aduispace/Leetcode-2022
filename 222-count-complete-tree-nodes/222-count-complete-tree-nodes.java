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
    // Time: O(logN*logN)
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        TreeNode left = root, right = root;
        int leftHeight = 0, rightHeight = 0;
        // time: O(logN), 树的高度 O(logN)
        while (left != null) {
            leftHeight++;
            left = left.left;
        }
        while (right != null) {
            rightHeight++;
            right = right.right;
        }
        // check if this is a full perfect binary tree, if yes get it in O(1), otherwise iterate over it would be O(logN) * O(logN), 由于完全二叉树的性质，其子树一定有一棵是满的，所以一定会触发 hl == hr，只消耗 O(logN) 的复杂度而不会继续递归.
        if (leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}

// class Solution {
//     public int countNodes(TreeNode root) {
//         // recursion solution: 
//         if (root == null) return 0;
//         return countNodes(root.left) + countNodes(root.right) + 1;
//     }
    
// }