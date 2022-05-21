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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> leftBound = new ArrayList<>();
        List<Integer> rightBound = new ArrayList<>();
        List<Integer> leaves = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        
        if (root.left != null || root.right != null) {
            res.add(root.val);
        }
                
        getLeftBoundary(root.left, leftBound);
        getRightBoundary(root.right, rightBound);
        getLeaves(root, leaves);
        
        res.addAll(leftBound);
        res.addAll(leaves);
        res.addAll(rightBound);
        
        return res;
    }
    
    private void getLeftBoundary(TreeNode root, List<Integer> leftList) {
        if (root != null && root.left == null && root.right == null) {
            // 不计入叶子结点
            return;
        }
        if (root != null && root.left != null) {
            leftList.add(root.val);
            getLeftBoundary(root.left, leftList);
        }
        if (root != null && root.left == null && root.right != null) {
            leftList.add(root.val);
            getLeftBoundary(root.right, leftList);
        }
    }
    
    private void getRightBoundary(TreeNode root, List<Integer> rightList) {
        if (root != null && root.left == null && root.right == null) {
            // 不计入叶子结点
            return;
        }
        if (root != null && root.right != null) {
            //  reverse order of the right boundary. 逆序打印所以后序遍历
            getRightBoundary(root.right, rightList);
            rightList.add(root.val);
        }
        if (root != null && root.right == null && root.left != null) {
            getRightBoundary(root.left, rightList);
            rightList.add(root.val);
        }
    }
    
    private void getLeaves(TreeNode root, List<Integer> leaves) {   
        if (root == null) return;
        
        if (root != null && root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        } 
        getLeaves(root.left, leaves);
        getLeaves(root.right, leaves);
    }
}