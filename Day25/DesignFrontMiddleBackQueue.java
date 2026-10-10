import java.util.ArrayDeque;
import java.util.Deque;

public class DesignFrontMiddleBackQueue {
    // Dual deque queue supporting O(1) front, middle, and back push and pop operations
    private final Deque<Integer> left;
    private final Deque<Integer> right;

    public DesignFrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    private void rebalance() {
        if (left.size() > right.size() + 1) {
            right.addFirst(left.removeLast());
        } else if (left.size() < right.size()) {
            left.addLast(right.removeFirst());
        }
    }

    public void pushFront(int val) {
        left.addFirst(val);
        rebalance();
    }

    public void pushMiddle(int val) {
        if (left.size() > right.size()) {
            right.addFirst(left.removeLast());
        }
        left.addLast(val);
        rebalance();
    }

    public void pushBack(int val) {
        right.addLast(val);
        rebalance();
    }

    public int popFront() {
        if (left.isEmpty()) return -1;
        int val = left.removeFirst();
        rebalance();
        return val;
    }

    public int popMiddle() {
        if (left.isEmpty()) return -1;
        int val = left.removeLast();
        rebalance();
        return val;
    }

    public int popBack() {
        if (left.isEmpty()) return -1;
        int val = right.isEmpty() ? left.removeLast() : right.removeLast();
        rebalance();
        return val;
    }

    public static void main(String[] args) {
        DesignFrontMiddleBackQueue q = new DesignFrontMiddleBackQueue();
        q.pushFront(1);   // [1]
        q.pushBack(2);    // [1, 2]
        q.pushMiddle(3);  // [1, 3, 2]
        q.pushMiddle(4);  // [1, 4, 3, 2]
        System.out.println("popFront: " + q.popFront());   // 1
        System.out.println("popMiddle: " + q.popMiddle()); // 3
        System.out.println("popMiddle: " + q.popMiddle()); // 4
        System.out.println("popBack: " + q.popBack());     // 2
        System.out.println("popFront: " + q.popFront());   // -1
    }
}