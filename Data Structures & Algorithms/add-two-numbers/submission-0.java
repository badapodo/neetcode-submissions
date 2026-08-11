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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int ret = 0;
        int carry = 0;
        carry = (l1.val + l2.val) / 10;
        ListNode head = new ListNode((l1.val + l2.val) % 10);
        l1 = l1.next;
        l2 = l2.next;
        ListNode curr = head;
        while (l1 != null || l2 != null) {
            int tmp = carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            carry = tmp / 10;
            tmp = tmp % 10;
            curr.next = new ListNode(tmp);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) curr.next = new ListNode(carry);
        return head;
    }
}
