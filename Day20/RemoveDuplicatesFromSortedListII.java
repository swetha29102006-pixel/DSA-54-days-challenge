// LeetCode 82: Remove Duplicates from Sorted List II

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveDuplicatesFromSortedListII {
    /**
     * Deletes all nodes that have duplicate numbers leaving only distinct numbers.
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        RemoveDuplicatesFromSortedListII solution = new RemoveDuplicatesFromSortedListII();
        ListNode res = solution.deleteDuplicates(head);
        System.out.println("Modified list head val: " + (res != null ? res.val : "null")); // Output: 1
    }
}