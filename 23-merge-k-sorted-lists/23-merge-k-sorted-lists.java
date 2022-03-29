/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        // [1, 1, 2]
        ListNode dummyHead = new ListNode();
        ListNode p = dummyHead;
        Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // O(NlogK), k is length of lists, n is total number of listnode processed by PQ
        // pre process the first element of each list!!!
        for (ListNode i : lists) {
            if (i != null) {
                minHeap.offer(i);
                i = i.next;
            }
        }
        
        while (!minHeap.isEmpty()) {
            ListNode curMin = minHeap.poll();
            if (curMin.next != null) {
                minHeap.offer(curMin.next);
            }
            p.next = new ListNode(curMin.val);
            p = p.next;
        }
        
        return dummyHead.next;
    }
}