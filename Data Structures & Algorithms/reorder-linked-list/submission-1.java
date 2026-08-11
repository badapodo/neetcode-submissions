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
    public void reorderList(ListNode head) {
        List<ListNode> lst = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            lst.add(curr);
            curr = curr.next;
        }
        int n = lst.size();
        curr = head;
        //홀수 1->2->3, 1->3->2
        //짝수 1->2->3->4 , 1->4->3->2
        for (int i = 0; i < n - 1; i++) {
            // System.out.print("curr: " + curr.val + "\n");
            if (i % 2 == 0) {
                ListNode nextNode = lst.get(n - (i / 2) - 1);
                // System.out.print("next: " + nextNode.val + "\n");
                curr.next = nextNode;
                curr = curr.next;
                continue;
            }
            ListNode nextNode = lst.get(i / 2 + 1);
            System.out.print("next: " + nextNode.val + "\n");
            curr.next = nextNode;
            curr = curr.next;
        }
        curr.next = null;
        //return lst.get(0);
    }
}
