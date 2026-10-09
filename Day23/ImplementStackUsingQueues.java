import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 225: Implement Stack using Queues
 * Implement a last-in-first-out (LIFO) stack using only standard queue operations.
 * Time Complexity: O(N) for push, O(1) for pop, top, empty.
 * Space Complexity: O(N) for queue storage.
 */
public class ImplementStackUsingQueues {
    private Queue<Integer> queue;

    public ImplementStackUsingQueues() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues stack = new ImplementStackUsingQueues();
        stack.push(1);
        stack.push(2);
        System.out.println("Top: " + stack.top());   // 2
        System.out.println("Pop: " + stack.pop());   // 2
        System.out.println("Empty: " + stack.empty()); // false
    }
}