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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode pre = dummyHead;
        ListNode cur = head;
        int i = 1;
        while (i < left) {
            pre = pre.next;
            cur = cur.next;
            i++;
        }
        ListNode oneBeforeStart = pre;
        while (i <= right) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            i++;
        }
        oneBeforeStart.next.next = cur;
        oneBeforeStart.next = pre;
        
        return dummyHead.next;
    }
}