/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // BFS
        if (node == null) return null;
        
        Map<Node, Node> map = new HashMap<>(); // original Node to its cloned node
        Node root = new Node(node.val);
        Queue<Node> q = new LinkedList<>();

        q.add(node);
        map.put(node, root);
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node neighbor : cur.neighbors) {
                // if it is never cloned
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    q.offer(neighbor);
                }
                // add to cloned cur node neighbors
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        
        return root;
    }
}