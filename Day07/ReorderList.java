class Solution {

    public void reorderList(ListNode head) {

        // find mid
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
    }
}
