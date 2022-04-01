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
        // postOrder: left -> right -> root
        // preorder: root -> left -> right, so we could do root -> right -> left and revert the result to be: left -> right -> root, which is postorder
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            // left first in, last out
            if (cur.left != null) {
                stack.push(cur.left);
            }
            // right last in, first out
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        Collections.reverse(res);
        
        return res;
    }
}

// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         postOrder(root, res);
//         return res;
//     }
    
//     private void postOrder(TreeNode root, List<Integer> res) {
//         if (root == null) return;
//         postOrder(root.left, res);
//         postOrder(root.right, res);
//         res.add(root.val);
//     }
// }