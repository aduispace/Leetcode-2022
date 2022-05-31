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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        maxHeight(root, res);
        
        return res;
    }
    
    private int maxHeight(TreeNode root, List<List<Integer>> res) {
        if (root == null) return 0;
        
        int curHeight = Math.max(maxHeight(root.left, res), maxHeight(root.right, res)) + 1;
        
        if (res.size() < curHeight) {
            res.add(new ArrayList<Integer>());
        }
        
        // null是第0层，叶子是第一层
        res.get(curHeight - 1).add(root.val);
        
        return curHeight;
    }
}