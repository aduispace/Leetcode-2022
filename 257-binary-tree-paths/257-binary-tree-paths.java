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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> path = new ArrayList<>();
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        traverse(root, path, res); 
        
        return res;
    }
    
    private void traverse(TreeNode root, List<String> path, List<String> res) {
        if (root.left == null && root.right == null) {
            path.add(root.val + "");
            // process the entire path and add to res
            String cur = "";
            for (int i = 0; i < path.size() - 1; i++) {
                cur = cur + path.get(i) + "->";
            }
            cur += path.get(path.size() - 1);
            res.add(cur);
            
            // backtrack when meet a leaf node
            path.remove(path.size() - 1);
            return;
        }
        if (root.left != null) {
            path.add(root.val + "");
            traverse(root.left, path, res);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.val + "");
            traverse(root.right, path, res);
            path.remove(path.size() - 1);
        }
        
        return;
    }
}