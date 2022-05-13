/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        TreeNode successor = null;

        if (root.val > p.val) {
            // 父节点收到 null 的话说明自己是 successor
            successor = inorderSuccessor(root.left, p);
            if (successor == null) {
                successor = root;
            }
        }
        if (root.val < p.val) {
            successor = inorderSuccessor(root.right, p);
        }

        if (root.val == p.val) {
            // 我是目标节点，我的 successor 要么是右子树的最小节点，要么是父节点
            successor = getMinNode(root.right);
        }

        return successor;
    }

    // BST 中最左侧的节点就是最小节点
    private TreeNode getMinNode(TreeNode p) {
        while (p != null && p.left != null) {
            p = p.left;
        }
        return p;
    }
//         if (root == null) return null;
//         TreeNode res = null;
        
//         if (root.val > p.val) {
//             res = inorderSuccessor(root.left, p);
//             if (res == null) {
//                 return root;
//             }
//         } else if (root.val < p.val) {
//             res = inorderSuccessor(root.right, p);
//         } else {
//             res = getMinNode(root.right);
//         }
        
//         return res;
//     }
    
//     private TreeNode getMinNode(TreeNode root) {
//         if (root != null && root.left != null) {
//             root = root.left;
//         }
        
//         return root;
//     }
    
    
}

    // O(N)解法，但不够快
//     boolean found = false;
//     TreeNode res = null;
    
//     public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//         inorder(root, p);
        
//         return res;
//     }
    
//     private void inorder(TreeNode root, TreeNode target) {
//         if (root == null) return;
        
//         inorder(root.left, target);
//         // inorder place
//         if (found) { 
//             res = root;
//             found = false;
//         }
//         if (root == target) {
//             found = true;
//         }
        
//         inorder(root.right, target);
        
//         return;
//     }