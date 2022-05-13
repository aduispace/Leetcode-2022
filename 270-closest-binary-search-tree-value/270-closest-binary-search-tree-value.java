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
    int res = Integer.MAX_VALUE;
    
    public int closestValue(TreeNode root, double target) {
        traverse(root, target);
        return res;
    }
    
    private void traverse(TreeNode root, double target) {
        if (root == null) return;
        res = Math.abs(root.val - target) < Math.abs(res - target) ? root.val : res;
        if (root.val > target) {
            traverse(root.left, target);
        } else {
            traverse(root.right, target);
        }
    }
}



// class Solution {
//     double min = Double.MAX_VALUE;
//     int res;
    
//     public int closestValue(TreeNode root, double target) {
//         traverse(root, target);
//         return res;
//     }
    
//     private void traverse(TreeNode root, double target) {
//         if (root == null) return;
//         traverse(root.left, target);
//         if (Math.abs(target - (double) root.val) < min) {
//             min = Math.abs(target - (double) root.val);
//             res = root.val;
//         }
//         traverse(root.right, target);
        
//         return;
//     }
// }