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
    List<TreeNode> res = new ArrayList<>();
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        if (!set.contains(root.val)) {
            res.add(root);
        }
        
        delete(root, set);
        return res;
    }
    
    private TreeNode delete(TreeNode root, Set<Integer> set) {
        // divide and conquer buttom up, deal with the level when exit the node
        if (root == null) return null;
        
        root.left = delete(root.left, set);
        root.right = delete(root.right, set);
        
        if (set.contains(root.val)) {
            if (root.left != null) res.add(root.left);
            if (root.right != null) res.add(root.right);
            return null;
        }
        
        // 返回修剪过的root
        return root;
    }
}


// public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
//         Set<Integer> set = new HashSet<>();
//         for (int i : to_delete) set.add(i);
//         List<TreeNode> res = new ArrayList<>();
//         if (!set.contains(root.val)) res.add(root);
//         dfs(root, set, res);
//         return res;
//     }

//     private TreeNode dfs(TreeNode node, Set<Integer> set, List<TreeNode> res) {
//         if (node == null) {
//             return null;
//         }
//         node.left = dfs(node.left, set, res);
//         node.right = dfs(node.right, set, res);
//         if (set.contains(node.val)) {
//             if (node.left != null) res.add(node.left);
//             if (node.right != null) res.add(node.right);
//             return null;
//         }
//         return node;
//     }