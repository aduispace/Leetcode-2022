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
    // preorder [root, leftTree, rightTree]
    // inorder [leftTree, root, rightTree]
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
        
        
        root.left = buildSubTree(preorder, newLeftPreOrderLeft, newLeftPreOrderRight, inorder, newLeftInOrderLeft, newLeftInOrderRight);
        root.right = buildSubTree(preorder, newRightPreOrderLeft, newRightPreOrderRight, inorder, newRightInOrderLeft, newRightInOrderRight);
        
        return root;
        
    }
}