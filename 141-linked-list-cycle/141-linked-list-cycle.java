/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        int meetAgain = 0;
        ListNode slow = head, fast = head;
        while (meetAgain < 2) {
            if (slow == fast) meetAgain++;
            fast = fast == null || fast.next == null ? null : fast.next.next;
            slow = slow == null ? null : slow.next;
        }
        
        return slow != null;
    }
}