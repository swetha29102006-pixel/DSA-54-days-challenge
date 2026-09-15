class Solution {

    public void reorderList(ListNode head) {

        // find mid
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow.next;

        slow.next = null;

        ListNode prev = null;
        ListNode next = null;

        // reverse right part
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // zigzag merge
        ListNode lh = head;
        ListNode rh = prev;
        ListNode nxtL, nxtR;

        while (lh != null && rh != null) {
            nxtL = lh.next;
            lh.next = rh;

            nxtR = rh.next;
            rh.next = nxtL;

            rh = nxtR;
            lh = nxtL;
        }
    }
}
