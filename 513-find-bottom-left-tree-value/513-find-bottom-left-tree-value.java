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
    private int maxDepth = 0;
    private TreeNode res = null;
    
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        traverse(root, 0);
        return res.val;
    }
    
    private void traverse(TreeNode root, int depth) {
        if (root == null) return;
        depth++;
        if (depth > maxDepth) {
            res = root;
            maxDepth = depth;
        }
        traverse(root.left, depth);
        traverse(root.right, depth);
        depth--;
    }
}
// BFS solution: 

// class Solution {
//     public int findBottomLeftValue(TreeNode root) {
//         // the leftmost value in the last row of the tree, the last row告诉我们可以bfs
//         Queue<TreeNode> queue = new LinkedList<>();
//         if (root == null) return 0;
//         TreeNode leftMost = root;
//         queue.offer(root);
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 TreeNode cur = queue.poll();
//                 if (i == 0) leftMost = cur;
//                 if (cur.left != null) {
//                     queue.offer(cur.left);
//                 }
//                 if (cur.right != null) {
//                     queue.offer(cur.right);
//                 }
//             }
//         }
        
//         return leftMost.val;
//     }
// }