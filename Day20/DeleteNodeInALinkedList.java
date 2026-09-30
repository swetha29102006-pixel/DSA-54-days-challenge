// LeetCode 237: Delete Node in a Linked List

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class DeleteNodeInALinkedList {
    /**
     * Deletes a given node in a singly linked list without head access.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(9);
        ListNode n3 = new ListNode(1, n4);
        ListNode n2 = new ListNode(5, n3);
        ListNode head = new ListNode(4, n2);

        DeleteNodeInALinkedList solution = new DeleteNodeInALinkedList();
        solution.deleteNode(n2); // Deletes node with value 5
        System.out.println("Head next val after deletion: " + head.next.val); // Output: 1
    }
}