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

    public boolean enQueue(int value) {
        if (isFull()) return false;
        QueueNode newNode = new QueueNode(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        size++;
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}