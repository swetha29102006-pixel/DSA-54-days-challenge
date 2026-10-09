import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 232: Implement Queue using Stacks
 * Implement a first-in-first-out (FIFO) queue using two stacks.
 * Time Complexity: Amortized O(1) for push, pop, peek, and empty operations.
 * Space Complexity: O(N) for internal stack storage.
 */
public class ImplementQueueUsingStacks {
    private Deque<Integer> inStack;
    private Deque<Integer> outStack;

    public ImplementQueueUsingStacks() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        peek();
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();
        queue.push(1);
        queue.push(2);
        System.out.println("Peek: " + queue.peek());   // 1
        System.out.println("Pop: " + queue.pop());     // 1
        System.out.println("Empty: " + queue.empty()); // false
    }
}