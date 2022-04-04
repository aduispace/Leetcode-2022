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
// DFS: go right first then left,
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, 0, res);
        
        return res;
    }
    
    private void dfs(TreeNode root, int depth, List<Integer> res) {
        if (depth == res.size()) {
            res.add(root.val);
        }
        
        if (root.right != null) dfs(root.right, depth + 1, res);
        // you have to travese left side because of somes cases like
        //   1
        //  / \
        // 2
        // expected result is [1, 2]
        if (root.left != null) dfs(root.left, depth + 1, res);
    }
}

// BFS: Level order traverse
// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         Queue<TreeNode> queue = new LinkedList<>();
//         List<Integer> res = new ArrayList<>();
//         if (root == null) return res;
//         queue.offer(root);
        
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 TreeNode cur = queue.poll();
//                 if (i == size - 1) {
//                     res.add(cur.val);
//                 }
//                 if (cur.left != null) queue.offer(cur.left);
//                 if (cur.right != null) queue.offer(cur.right);
//             }
//         }
        
//         return res;
//     }
// }