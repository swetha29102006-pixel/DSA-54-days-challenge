import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverageFromDataStream {
    private final int size;
    private final Deque<Integer> queue;
    private double windowSum;

    public MovingAverageFromDataStream(int size) {
        this.size = size;
        this.queue = new ArrayDeque<>();
        this.windowSum = 0.0;
    }

    public double next(int val) {
        queue.offer(val);
        windowSum += val;
        return 0.0;
    }
}