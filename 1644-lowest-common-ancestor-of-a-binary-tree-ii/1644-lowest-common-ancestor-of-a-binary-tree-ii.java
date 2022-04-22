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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!find(root, p) || !find(root, q)) {
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
    
    private boolean find(TreeNode root, TreeNode target) {
        if (root == null) return false;
        if (root == target) {
            return true;
        } else {
            return find(root.left, target) || find(root.right, target);
        }
    }
}