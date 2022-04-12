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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // BFS: O(N) time and O(2N) space for map and queue
        
        
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>(); // diameter to its list map
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        // leftMost/rightMost trackers should start with 0
        int leftMost = 0;
        int rightMost = 0;
        queue.offer(new Node(root, 0));
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (!map.containsKey(cur.level)) {
                    map.put(cur.level, new ArrayList<Integer>());
                } 
                map.get(cur.level).add(cur.node.val);
                if (cur.node.left != null) {
                    queue.offer(new Node(cur.node.left, cur.level - 1));
                    leftMost = Math.min(leftMost, cur.level - 1);
                }
                if (cur.node.right != null) {
                    queue.offer(new Node(cur.node.right, cur.level + 1));
                    rightMost = Math.max(rightMost, cur.level + 1);
                }
            }
        }
        
        for (int i = leftMost; i <= rightMost; i++) {
            res.add(map.get(i));
        }
        
        return res;
    }
    
    private class Node {
        int level;
        TreeNode node;
        public Node(TreeNode node, int lvl) {
            this.node = node;
            this.level = lvl;
        }
    }
}