/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node pointerA = p;
        Node pointerB = q;
        
        while (pointerA != pointerB) {
            if (pointerA == null) {
                pointerA = q;
            } else {
                pointerA = pointerA.parent;
            }
            
            if (pointerB == null) {
                pointerB = p;
            } else {
                pointerB = pointerB.parent;
            }
        }
        
        return pointerA;
    }
}