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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildBST(int[] nums, int left, int right) {
        if (nums == null || nums.length == 0) return null;
        if (left > right) return null;
        
//         首先取数组中间元素的位置，不难写出int mid = (left + right) / 2;，这么写其实有一个问题，就是数值越界，例如left和right都是最大int，这么操作就越界了，在二分法 (opens new window)中尤其需要注意！
// 所以可以这么写：int mid = left + ((right - left) / 2);
        
        
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);
        
        return root;
    }
}