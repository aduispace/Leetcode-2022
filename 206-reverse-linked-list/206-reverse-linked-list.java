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
    public ListNode reverseList(ListNode head) {
        // bottom up recursion stack: recursion从最右边开始也就是最后进的那层
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reversedHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reversedHead;
        
//         // Iteration写法: 
//         ListNode pre = null;
//         // Maintain 3 pointers: pre, cur(head), next
//         // head必须要跑到null为止，此时反转linkedlist的头是pre！！！
//         while (head != null) {
//             ListNode next = head.next;
//             head.next = pre;
//             pre = head;
//             head = next;
//         }
        
//         return pre;
//     }
    }
}