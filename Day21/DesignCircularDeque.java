class DequeNode {
    int val;
    DequeNode prev;
    DequeNode next;
    DequeNode(int val) {
        this.val = val;
    }
}

public class DesignCircularDeque {
    private final DequeNode head;
    private final DequeNode tail;
    private final int capacity;
    private int size;

    public DesignCircularDeque(int k) {
        this.capacity = k;
        this.size = 0;
        this.head = new DequeNode(-1);
        this.tail = new DequeNode(-1);
        head.next = tail;
        tail.prev = head;
    }
}