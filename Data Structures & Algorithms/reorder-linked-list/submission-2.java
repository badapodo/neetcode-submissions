class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // 1. 중간 지점 찾기
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 뒤쪽 절반 분리 + reverse
        ListNode curr = slow.next;
        slow.next = null;

        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // prev가 뒤집힌 두 번째 리스트의 head
        ListNode first = head;
        ListNode second = prev;

        // 3. 두 리스트를 번갈아 연결
        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }
}