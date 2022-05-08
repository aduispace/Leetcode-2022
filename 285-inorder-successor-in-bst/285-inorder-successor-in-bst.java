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
    boolean found = false;
    TreeNode res = null;
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root, p);
        
        return res;
    }
    
    private void inorder(TreeNode root, TreeNode target) {
        if (root == null) return;
        
        inorder(root.left, target);
        // inorder place
        if (found) { 
            res = root;
            found = false;
        }
        if (root == target) {
            found = true;
        }
        
        inorder(root.right, target);
        
        return;
    }
}