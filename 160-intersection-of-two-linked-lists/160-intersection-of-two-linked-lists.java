/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode result = null;
        while (headA != null) {
            ListNode pB = headB;
            while (pB != null) {
                if (pB == headA) {
                    return pB;
                }
                pB = pB.next;
            }
            headA = headA.next;
        }
        return null;
    }
}