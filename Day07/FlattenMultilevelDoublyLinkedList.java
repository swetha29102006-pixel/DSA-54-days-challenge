class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;

        Node curr = head;

        while (curr != null) {
            if (curr.child != null) {

                Node nextNode = curr.next;
                Node childTail = curr.child;

                // Find the end of child list
                while (childTail.next != null) {
                    childTail = childTail.next;
                }

                // Connect child list to next part
                if (nextNode != null) {
                    childTail.next = nextNode;
                    nextNode.prev = childTail;
                }

                // Connect current node to child list
                curr.next = curr.child;
                curr.child.prev = curr;

                // Remove child pointer
                curr.child = null;
            }

            curr = curr.next;
        }

        return head;
    }
}
