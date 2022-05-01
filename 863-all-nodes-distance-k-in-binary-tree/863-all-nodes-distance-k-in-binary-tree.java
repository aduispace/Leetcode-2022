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
    Map<TreeNode, TreeNode> map = new HashMap<>(); // TreeNode to its parent node
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        traverse(root, null);
        
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        q.offer(target);
        visited.add(target);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (k == 0)  {
                    res.add(cur.val);
                } else if (k < 0) {
                    return res;
                }
                if (cur.left != null && !visited.contains(cur.left)) {
                    q.offer(cur.left);
                    visited.add(cur.left);
                }
                if (cur.right != null && !visited.contains(cur.right)) {
                    q.offer(cur.right);
                    visited.add(cur.right);
                }
                if (map.containsKey(cur) && map.get(cur) != null && !visited.contains(map.get(cur))) {
                    q.offer(map.get(cur));
                    visited.add(map.get(cur));
                }
            }
            k--;
        }
        
        return res;
    }
    
    private void traverse(TreeNode root, TreeNode parentNode) {
        if (root == null) return;
        map.put(root, parentNode);
        traverse(root.left, root);
        traverse(root.right, root);
    }
}