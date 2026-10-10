import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverageFromDataStream {
    // Computes moving average over sliding window queue of size N
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
        if (queue.size() > size) {
            windowSum -= queue.poll();
        }
        return windowSum / queue.size();
    }

    public static void main(String[] args) {
        MovingAverageFromDataStream ma = new MovingAverageFromDataStream(3);
        System.out.println("next(1): " + ma.next(1));   // 1.0
        System.out.println("next(10): " + ma.next(10)); // 5.5
        System.out.println("next(3): " + ma.next(3));   // 4.66667
        System.out.println("next(5): " + ma.next(5));   // 6.0
    }
}