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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildSubTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    // preorder partition [root, leftTree, rightTree]
    // inorder partition [leftTree, root, rightTree]
    // divide conquer 一般有返回值
    private TreeNode buildSubTree(int[] preorder, int preOrderLeft, int preOrderRight, int[] inorder, int inOrderLeft, int inOrderRight) {
        if (preOrderLeft > preOrderRight || preOrderLeft > preorder.length - 1) return null; 
        int rootVal = preorder[preOrderLeft];
        TreeNode root = new TreeNode(rootVal);
        int pos = inOrderLeft;
        while (inorder[pos] != rootVal && pos <= inOrderRight) {
            pos++;
        }
        
        int newLeftPreOrderLeft = preOrderLeft + 1;
        int newLeftPreOrderRight = pos - inOrderLeft + preOrderLeft;
        int newRightPreOrderLeft = newLeftPreOrderRight + 1;
        int newRightPreOrderRight = preOrderRight;
        
        int newLeftInOrderLeft = inOrderLeft;
        int newLeftInOrderRight = pos - 1;
        int newRightInOrderLeft = pos + 1;
        int newRightInOrderRight = inOrderRight;
        
        // divide and conquer: 二叉树的构造问题一般都是使用「分解问题」的思路：构造整棵树 = 根节点 + 构造左子树 + 构造右子树。

        root.left = buildSubTree(preorder, newLeftPreOrderLeft, newLeftPreOrderRight, inorder, newLeftInOrderLeft, newLeftInOrderRight);
        root.right = buildSubTree(preorder, newRightPreOrderLeft, newRightPreOrderRight, inorder, newRightInOrderLeft, newRightInOrderRight);
        
        return root;
        
    }
}