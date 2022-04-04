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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        q.offer(root);
        // BFS: using Queue
        // while 循环控制从上向下一层层遍历
        while (!q.isEmpty()) {
            int size = q.size();
            // 记录这一层的节点值
            List<Integer> curRes = new ArrayList<>();
            // i < size but not i < q.size(), because we keep poll out queue
            // for 循环控制每一层从左向右遍历
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                curRes.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            res.add(curRes);
        }
        
        return res;
    }
}