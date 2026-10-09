import java.util.ArrayDeque;
import java.util.Deque;

public class OnlineStockSpan {
    private Deque<int[]> stack;

    public OnlineStockSpan() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        stack.push(new int[]{price, span});
        return span;
    }
}