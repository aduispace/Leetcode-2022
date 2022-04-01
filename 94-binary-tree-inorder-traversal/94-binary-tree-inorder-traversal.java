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
    public List<Integer> inorderTraversal(TreeNode root) {
        // inorder: left -> root -> right
        // 中序遍历顺序: 左-中-右 入栈顺序： 左-右
        // inorder needs an addition pointer to handle adding result
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.pop();
                res.add(node.val);
                cur = node.right;
            }
        }
        
        return res;
    }
}


// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         inOrder(root, res);
//         return res;
//     }
    
//     private void inOrder(TreeNode root, List<Integer> res) {
//         if (root == null) return;
//         inOrder(root.left, res);
//         res.add(root.val);
//         inOrder(root.right, res);
//     }
// }