import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 901: Online Stock Span
 * Calculate the span of a stock's price for the current day using a monotonic stack.
 * Time Complexity: Amortized O(1) per call to next.
 * Space Complexity: O(N) for stack storage.
 */
public class OnlineStockSpan {
    // Monotonic stack storing [price, span] pairs
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

    public static void main(String[] args) {
        OnlineStockSpan stockSpan = new OnlineStockSpan();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        System.out.print("Stock Spans: ");
        for (int p : prices) {
            System.out.print(stockSpan.next(p) + " ");
        }
        System.out.println();
    }
}