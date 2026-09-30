// LeetCode 83: Remove Duplicates from Sorted List

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();
        ListNode res = solution.deleteDuplicates(head);
        System.out.println("Modified list head next val: " + (res != null && res.next != null ? res.next.val : "null")); // 2
    }
}