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
    public boolean hasCycle(ListNode head) {
        ListNode jump = head;
        while (jump != null && jump.next != null) {
            jump = jump.next.next;
            head = head.next;
            if (jump == head) return true;
        }
        return false;
    }
}
