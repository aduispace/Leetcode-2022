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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if (root == null) return null;
        TreeNode res = null;
        
        if (root.val > p.val) {
            res = inorderSuccessor(root.left, p);
            if (res == null) {
                res = root;
            }
        } else if (root.val < p.val) {
            res = inorderSuccessor(root.right, p);
        } else if (root.val == p.val) {
            res = getMinNode(root.right);
        }
        
        return res;
    }
    
    private TreeNode getMinNode(TreeNode root) {
        while (root != null && root.left != null) {
            root = root.left;
        }
        
        return root;
    }
    
    
}

    // O(N)解法，但不够快
//     boolean found = false;
//     TreeNode res = null;
    
//     public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//         inorder(root, p);
        
//         return res;
//     }
    
//     private void inorder(TreeNode root, TreeNode target) {
//         if (root == null) return;
        
//         inorder(root.left, target);
//         // inorder place
//         if (found) { 
//             res = root;
//             found = false;
//         }
//         if (root == target) {
//             found = true;
//         }
        
//         inorder(root.right, target);
        
//         return;
//     }