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
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            curr = curr.next;
            size++;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        curr = dummy;
        int i = 0;
        while (curr != null) {
            if (i == size - n) {
                System.out.print(curr.next.val);
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
            i++;
        }
        return dummy.next;
    }
}
