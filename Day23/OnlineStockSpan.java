import java.util.ArrayDeque;
import java.util.Deque;

public class OnlineStockSpan {
    private Deque<int[]> stack;

    public OnlineStockSpan() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        return 1;
    }
}