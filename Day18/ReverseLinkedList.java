// LeetCode 206: Reverse Linked List

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseLinkedList {
    /**
     * Reverses a singly linked list in-place using 3 pointers.
     * Time Complexity: O(N) - single pass over N nodes.
     * Space Complexity: O(1) - auxiliary space constant.
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode reversed = solution.reverseList(head);
        System.out.println("Reversed head val: " + (reversed != null ? reversed.val : "null")); // Output: 3
    }
}