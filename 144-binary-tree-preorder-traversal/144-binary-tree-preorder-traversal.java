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

/*
1. Iteration: 
**/
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // preorder: root -> left -> right
        // stack entrance sequence: root -> right -> left, first in last out!!!
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res; 
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        
        return res;
    }
}

/*
2. recursion: 
**/

// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         preOrder(root, res);
//         return res;
//     }
    
//     private void preOrder(TreeNode root, List<Integer> res) {
//         if (root == null) return;
//         res.add(root.val);
//         preOrder(root.left, res);
//         preOrder(root.right, res);
//     }
// }