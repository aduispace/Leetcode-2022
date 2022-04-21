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
    Map<Integer, Integer> valToPos = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToPos.put(inorder[i], i);
        }
        return buildSubTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    // inorder: [leftTree, root, rightTree]
    // postorder: [leftTree, rightTree, root]
    private TreeNode buildSubTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return null;
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        
        int inPos = valToPos.get(rootVal);
        int leftLength = inPos - inStart;
        
        root.left = buildSubTree(inorder, inStart, inPos - 1, postorder, postStart, postStart + leftLength - 1);
        root.right = buildSubTree(inorder, inPos + 1, inEnd, postorder, postStart + leftLength, postEnd - 1);
        
        return root;
    }

}