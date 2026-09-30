// LeetCode 92: Reverse Linked List II

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseLinkedListII {
    /**
     * Reverses nodes of a linked list from position left to position right.
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode nextTemp = curr.next;
            curr.next = nextTemp.next;
            nextTemp.next = prev.next;
            prev.next = nextTemp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ReverseLinkedListII solution = new ReverseLinkedListII();
        ListNode res = solution.reverseBetween(head, 2, 4);
        System.out.println("Modified list head next val: " + (res != null && res.next != null ? res.next.val : "null")); // Output: 4
    }
}