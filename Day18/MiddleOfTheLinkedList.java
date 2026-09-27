// LeetCode 876: Middle of the Linked List

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MiddleOfTheLinkedList {
    /**
     * Finds the middle node of a linked list using slow/fast pointers.
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        MiddleOfTheLinkedList solution = new MiddleOfTheLinkedList();
        ListNode mid = solution.middleNode(head);
        System.out.println("Middle node val: " + (mid != null ? mid.val : "null")); // Output: 3
    }
}