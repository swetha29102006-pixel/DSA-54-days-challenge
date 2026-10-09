import java.util.ArrayDeque;
import java.util.Deque;

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

    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }
}