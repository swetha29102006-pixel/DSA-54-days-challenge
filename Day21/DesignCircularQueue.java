class QueueNode {
    int val;
    QueueNode next;
    QueueNode(int val) {
        this.val = val;
    }
}

public class DesignCircularQueue {
    private QueueNode head;
    private QueueNode tail;
    private final int capacity;
    private int size;

    public DesignCircularQueue(int k) {
        this.capacity = k;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}