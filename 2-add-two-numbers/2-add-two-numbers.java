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
    // [9, 9, 9, 9, 9, 9, 9] [8, 9, 9, 9, 0, 0, 0, 1]
    // [9, 9, 9, 9]
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        // time:  O(max(m, n))
        ListNode p1 = l1, p2 = l2;
        int carryOver = 0;
        // 注意dummyhead，dummyhead不动
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        while (p1 != null || p2 != null) {
            // 简化code 不需要分情况讨论p1 和 p2
            int val1 = p1 == null ? 0 : p1.val;
            int val2 = p2 == null ? 0 : p2.val;
            int val = (val1 + val2 + carryOver) % 10;
            cur.next = new ListNode(val);
            carryOver = (val1 + val2 + carryOver) / 10;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
            cur = cur.next;
            
            // if (p1 != null && p2 != null) {
            //     int val = (p1.val + p2.val + carryOver) % 10;
            //     cur.next = new ListNode(val);
            //     carryOver = (p1.val + p2.val + carryOver) / 10;
            //     p1 = p1.next;
            //     p2 = p2.next;
            //     cur = cur.next;
            // } else if (p1 == null && p2 != null) {
            //     int val = (p2.val + carryOver) % 10;
            //     cur.next = new ListNode(val);
            //     carryOver = (p2.val + carryOver) / 10;
            //     p2 = p2.next;
            //     cur = cur.next;
            // } else if (p1 != null && p2 == null) {
            //     int val = (p1.val + carryOver) % 10;
            //     cur.next = new ListNode(val);
            //     carryOver = (p1.val + carryOver) / 10;
            //     p1 = p1.next;
            //     cur = cur.next;
            // }
        }
        
        if (carryOver != 0) {
            cur.next = new ListNode(1, null);
        }
        
        return dummyHead.next;
    }
}