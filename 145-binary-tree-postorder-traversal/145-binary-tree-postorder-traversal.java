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
    // 后序遍历，先序遍历是中左右，后续遍历是左右中，那么我们只需要调整一下先序遍历的代码顺序，就变成中右左的遍历顺序，然后在反转result数组，输出的结果顺序就是左右中了
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
        
        // reverse order at last
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