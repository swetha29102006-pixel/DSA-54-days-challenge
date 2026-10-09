import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    private Queue<Integer> queue;

    public ImplementStackUsingQueues() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }
    }
}