import java.util.Collections;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int c : count) {
            if (c > 0) maxHeap.add(c);
        }

        int maxFreq = maxHeap.poll();
        int idleSlots = (maxFreq - 1) * n;

        while (!maxHeap.isEmpty()) {
            idleSlots -= Math.min(maxHeap.poll(), maxFreq - 1);
        }

        return idleSlots > 0 ? tasks.length + idleSlots : tasks.length;
    }
}