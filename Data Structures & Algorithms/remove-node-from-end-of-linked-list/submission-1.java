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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode next = head;
        ListNode curr = new ListNode();
        curr.next = head;
        ListNode dummy = curr;

        for (int i = 0; i < n; i++) {
            next = next.next;
        }

        while (next != null) {
            curr = curr.next;
            next = next.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }
}
