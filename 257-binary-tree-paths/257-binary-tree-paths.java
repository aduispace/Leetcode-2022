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
    // 回溯做法，本质是traverse
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
            // 前序位置
            path.add(root.val + "");
            traverse(root.left, path, res);
            // 后序位置
            // 这个解法应该很好理解，但为什么需要在前序位置增加 depth，在后序位置减小 depth？
// 因为前面说了，前序位置是进入一个节点的时候，后序位置是离开一个节点的时候，depth 记录当前递归到的节点深度，你把 traverse 理解成在二叉树上游走的一个指针，所以当然要这样维护。
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