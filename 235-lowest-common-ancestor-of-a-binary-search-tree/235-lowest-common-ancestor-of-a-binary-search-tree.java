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
        if (root == null) return null;
        
        // switch to make p < q, always
        if (p.val > q.val) {
            TreeNode temp = q;
            q = p;
            p = temp;
        }
        
        if (root.val >= p.val && root.val <= q.val) {
            // root.val is in the middle, it is the LCA
            return root;
        } else if (root.val < p.val) {
            // root.val is smallest, go right
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > q.val) {
            // root.val is largest, go left
            return lowestCommonAncestor(root.left, p, q);
        }
        
        return null;
    }
}