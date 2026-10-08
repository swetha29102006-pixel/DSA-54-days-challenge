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
        return head;
    }
}