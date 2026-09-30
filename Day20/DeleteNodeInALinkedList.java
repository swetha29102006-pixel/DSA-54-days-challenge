// LeetCode 237: Delete Node in a Linked List

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }

        // Copy value of next node
        node.val = node.next.val;
    }
}