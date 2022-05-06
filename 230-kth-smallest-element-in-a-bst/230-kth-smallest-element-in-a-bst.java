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

// Click here to learn how to insert a node into a BST and delete a node from a BST, the time complexity of these operations is O(H)O(H), where HH is a height of the binary tree. H = \log NH=logN for the balanced tree and H = NH=N for a skewed tree.


class Solution {
    int res;
    int cur = 0; 
    
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }
    
    // 这里不能带着cur int进traverse，因为int不是reference type而是primitive type
    // Time: O(K) return when we find k smallest 
    private void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.left, k);
        cur++;
        if (cur == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
        
        return;
    }
}