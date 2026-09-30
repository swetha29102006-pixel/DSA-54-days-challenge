// LeetCode 24: Swap Nodes in Pairs

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode point = dummy;

        while (point.next != null && point.next.next != null) {
            ListNode swap1 = point.next;
            ListNode swap2 = point.next.next;

            swap1.next = swap2.next;
            swap2.next = swap1;
        }
        return dummy.next;
    }
}