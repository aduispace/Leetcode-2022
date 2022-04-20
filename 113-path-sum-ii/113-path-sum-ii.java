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
    private List<List<Integer>> res = new ArrayList<>();
     
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        traverse(root, path, 0, targetSum);
        return res;
    }
    
    private void traverse(TreeNode root, List<Integer> path, int sum, int targetSum) {
        if (root == null) return;
        path.add(root.val);
        sum += root.val;
        if (root.left == null && root.right == null && sum == targetSum) {
            // 这里很重要，不能直接add path，因为path reference 回溯的时候会变，得deep copy一份过来
            List<Integer> cur = new ArrayList<>(path);
            res.add(cur);
            // 这段可有可无
            // path.remove(path.size() - 1);
            // sum -= root.val;
            // return;
        }
        
        traverse(root.left, path, sum, targetSum);
        traverse(root.right, path, sum, targetSum);
        
        path.remove(path.size() - 1);
        sum -= root.val;
        
        return;
    }
}