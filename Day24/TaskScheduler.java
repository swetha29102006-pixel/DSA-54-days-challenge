import java.util.Collections;
import java.util.PriorityQueue;

/**
 * LeetCode 621: Task Scheduler
 * Return the least number of units of time needed to finish all given tasks with cooling interval n.
 * Time Complexity: O(N) where N is number of tasks.
 * Space Complexity: O(1) for fixed 26 task frequency map and heap.
 */
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

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println("Least intervals: " + scheduler.leastInterval(tasks, 2)); // 8
    }
}