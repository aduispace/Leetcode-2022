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
class Solution {
    // preorder DFS: 交换左右子树的reference即可
    public TreeNode invertTree(TreeNode root) {
        preOrder(root);
        
        return root;
    }
    
    private void preOrder(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        
        preOrder(root.left);
        preOrder(root.right);
    }
    
}

//BFS
// class Solution {
//     public TreeNode invertTree(TreeNode root) {
//         if (root == null) {return null;}
//         ArrayDeque<TreeNode> deque = new ArrayDeque<>();
//         deque.offer(root);
//         while (!deque.isEmpty()) {
//             int size = deque.size();
//             while (size-- > 0) {
//                 TreeNode node = deque.poll();
//                 swap(node);
//                 if (node.left != null) {deque.offer(node.left);}
//                 if (node.right != null) {deque.offer(node.right);}
//             }
//         }
//         return root;
//     }

//     public void swap(TreeNode root) {
//         TreeNode temp = root.left;
//         root.left = root.right;
//         root.right = temp;
//     }
// }