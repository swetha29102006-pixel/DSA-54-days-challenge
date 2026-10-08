import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 155: Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in O(1) time.
 * Time Complexity: O(1) for push, pop, top, getMin.
 * Space Complexity: O(N) for primary and auxiliary min stacks.
 */
public class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int popped = stack.pop();
            if (popped == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Min: " + minStack.getMin()); // -3
        minStack.pop();
        System.out.println("Top: " + minStack.top());    // 0
        System.out.println("Min: " + minStack.getMin()); // -2
    }
}