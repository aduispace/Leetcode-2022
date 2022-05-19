/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder path = new StringBuilder();
        serializeHelper(root, path);
        return path.toString();
    }
    
    private void serializeHelper(TreeNode root, StringBuilder path) {
        if (root == null) { 
            path.append("#,");
            return;
        }
        
        path.append(root.val + ",");
        serializeHelper(root.left, path);
        serializeHelper(root.right, path);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        Queue<String> q = new LinkedList<>();
        for (String s : strs) {
            q.offer(s);
        }
        
        return deserializeHelper(q, null);
    }
    
    private TreeNode deserializeHelper(Queue<String> q, TreeNode root) {
        if (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.equals("#")) {
                return null;
            } else {
                int val = Integer.valueOf(cur);
                root = new TreeNode(val);
                root.left = deserializeHelper(q, root.left);
                root.right = deserializeHelper(q, root.right);
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));