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
    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Boolean> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) {
                return head;
            }
            map.put(head, true);
            head = head.next;
        }
        
        return head;
    }
}