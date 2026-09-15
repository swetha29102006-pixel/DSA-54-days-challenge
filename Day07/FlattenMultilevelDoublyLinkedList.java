class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;

        Node curr = head;

        while (curr != null) {
            if (curr.child != null) {
                Node childTail = curr.child;

                while (childTail.next != null) {
                    childTail = childTail.next;
                }
            }

            curr = curr.next;
        }

        return head;
    }
}
