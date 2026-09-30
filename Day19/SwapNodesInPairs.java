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
            point.next = swap2;
            point = swap1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        SwapNodesInPairs solution = new SwapNodesInPairs();
        ListNode swapped = solution.swapPairs(head);
        System.out.println("Swapped head val: " + (swapped != null ? swapped.val : "null")); // 2
    }
}