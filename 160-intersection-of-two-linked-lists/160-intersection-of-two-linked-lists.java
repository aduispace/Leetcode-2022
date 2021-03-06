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
        // brute force: O(MxN) 
        // while (headA != null) {
        //     ListNode pB = headB;
        //     while (pB != null) {
        //         if (pB == headA) {
        //             return pB;
        //         }
        //         pB = pB.next;
        //     }
        //     headA = headA.next;
        // }
        // return null;
        
        // Time: O(M+N), 跑到重合点之前两个指针走过的路一样长2+3 == 3+2
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? a = headB : a.next;
            b = b == null ? b = headA : b.next;
        }
        
        return a;
    }
}