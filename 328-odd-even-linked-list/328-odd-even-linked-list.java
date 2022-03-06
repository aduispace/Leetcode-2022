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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddPre = head, evenPre = head.next;
        ListNode evenStart = head.next; // oddStart = head; we don't need to record oddStart
        ListNode dummyHead = new ListNode(0, head);
        int i = 1;
        while (head != null) {
            // i > 2 because we need skip first two and they have been already setup as oddPre and evenPre
            if (i % 2 != 0 && i > 2) {
                oddPre.next = head;
                oddPre = head;
            } else if (i % 2 == 0 && i > 2) {
                evenPre.next = head;
                evenPre = head;
            }
            head = head.next;
            i++;
        }
        
        oddPre.next = evenStart;
        evenPre.next = null;
        
        return dummyHead.next;
    }
}