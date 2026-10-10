import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverageFromDataStream {
    private final int size;
    private final Deque<Integer> queue;
    private double windowSum;
}