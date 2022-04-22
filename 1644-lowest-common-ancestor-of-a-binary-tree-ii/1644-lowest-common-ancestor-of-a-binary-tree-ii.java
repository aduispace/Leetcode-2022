/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean pExist = false;
    boolean qExist = false;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p, q);
        if (!pExist || !qExist) {
            return null;
        }
        return findLCA(root, p, q);
    }
    
    private TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        // preorder position
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        
        return left != null ? left : right;
    }
    
    private void traverse(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return;
        if (root == p) {
            pExist = true;
        } else if (root == q) {
            qExist = true;
        }
        traverse(root.left, p, q);
        traverse(root.right, p, q);
        
        return;
    }
}