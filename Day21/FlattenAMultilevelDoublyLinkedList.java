class MultiNode {
    public int val;
    public MultiNode prev;
    public MultiNode next;
    public MultiNode child;

    public MultiNode() {}
    public MultiNode(int val) {
        this.val = val;
    }
}

public class FlattenAMultilevelDoublyLinkedList {
    public MultiNode flatten(MultiNode head) {
        if (head == null) return null;
        flattenDFS(head);
        return head;
    }

    private MultiNode flattenDFS(MultiNode node) {
        MultiNode curr = node;
        MultiNode last = null;

        while (curr != null) {
            MultiNode next = curr.next;
            if (curr.child != null) {
                MultiNode childTail = flattenDFS(curr.child);
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;

                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }
                last = childTail;
            } else {
                last = curr;
            }
            curr = next;
        }
        return last;
    }
}