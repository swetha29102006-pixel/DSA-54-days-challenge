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

    public boolean insertFront(int value) {
        if (isFull()) return false;
        DequeNode node = new DequeNode(value);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        DequeNode node = new DequeNode(value);
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        node.next = tail;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        DequeNode node = head.next;
        head.next = node.next;
        node.next.prev = head;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        DequeNode node = tail.prev;
        tail.prev = node.prev;
        node.prev.next = tail;
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : head.next.val;
    }

    public int getRear() {
        return isEmpty() ? -1 : tail.prev.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}