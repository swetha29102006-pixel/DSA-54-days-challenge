/**
 * LeetCode 622: Design Circular Queue
 * Design your implementation of the circular queue using a linked list ring.
 * Time Complexity: O(1) for all operations (enQueue, deQueue, Front, Rear, isEmpty, isFull).
 * Space Complexity: O(k) capacity.
 */
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

    public boolean deQueue() {
        if (isEmpty()) return false;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : head.val;
    }

    public int Rear() {
        return isEmpty() ? -1 : tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        DesignCircularQueue q = new DesignCircularQueue(3);
        System.out.println("enQueue 1: " + q.enQueue(1)); // true
        System.out.println("enQueue 2: " + q.enQueue(2)); // true
        System.out.println("enQueue 3: " + q.enQueue(3)); // true
        System.out.println("enQueue 4: " + q.enQueue(4)); // false
        System.out.println("Rear: " + q.Rear());          // 3
        System.out.println("isFull: " + q.isFull());      // true
        System.out.println("deQueue: " + q.deQueue());    // true
        System.out.println("enQueue 4: " + q.enQueue(4)); // true
        System.out.println("Rear: " + q.Rear());          // 4
    }
}