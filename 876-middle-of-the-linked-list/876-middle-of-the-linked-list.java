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
    public ListNode middleNode(ListNode head) {
        ListNode fast = head.next, slow = head;
        while (fast != null) {
            fast = fast.next != null ? fast.next.next : null;
            slow = slow.next;
        }
        
        return slow;
    }
}