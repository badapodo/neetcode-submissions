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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        return conquer(lists, 0, n - 1);
    }

    private ListNode conquer(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start == end - 1) return doConquer(lists[start], lists[end]);

        int mid = (start + end) >>> 1;
        return doConquer(conquer(lists, start, mid), conquer(lists, mid + 1, end));
    }

    private ListNode doConquer(ListNode a, ListNode b) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while (a != null && b != null) {
            if (a.val > b.val) {
                dummy.next = b;
                dummy = dummy.next;
                b = b.next;
                continue;
            }
            dummy.next = a;
            dummy = dummy.next;
            a = a.next;
        }
        if (a == null) dummy.next = b;
        else dummy.next = a;
        return head.next;
    }
}
