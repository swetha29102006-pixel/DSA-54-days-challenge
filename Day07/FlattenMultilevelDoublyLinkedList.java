class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;

        Node curr = head;

        while (curr != null) {
            curr = curr.next;
        }

        return head;
    }
}
