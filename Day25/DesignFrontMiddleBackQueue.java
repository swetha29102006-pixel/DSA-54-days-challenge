import java.util.ArrayDeque;
import java.util.Deque;

public class DesignFrontMiddleBackQueue {
    private final Deque<Integer> left;
    private final Deque<Integer> right;

    public DesignFrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }
}