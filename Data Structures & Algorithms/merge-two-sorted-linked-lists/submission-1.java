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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;

        ListNode head;
        if ((list1 == null ? 101 : list1.val) > (list2 == null ? 101 : list2.val)) {
            head = list2;
            list2 = list2.next;
        } else {
            head = list1;
            list1 = list1.next;
        }

        ListNode curr = head;

        while (list1 != null || list2 != null) {
            if ((list1 == null ? 101 : list1.val) > (list2 == null ? 101 : list2.val)) {
                // System.out.print("this: " + list2.val + "\n");
                curr.next = list2;
                list2 = list2.next;
            } else {
                // System.out.print("this: " + list1.val + "\n");
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }
        return head;
    }
}