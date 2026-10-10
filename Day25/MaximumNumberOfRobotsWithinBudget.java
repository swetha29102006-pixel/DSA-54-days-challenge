import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumNumberOfRobotsWithinBudget {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        Deque<Integer> maxDeque = new ArrayDeque<>();
        long costSum = 0;
        int left = 0;
        int maxRobots = 0;

        for (int right = 0; right < chargeTimes.length; right++) {
            while (!maxDeque.isEmpty() && chargeTimes[maxDeque.peekLast()] <= chargeTimes[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);
            costSum += runningCosts[right];

            while (!maxDeque.isEmpty() && chargeTimes[maxDeque.peekFirst()] + (right - left + 1) * costSum > budget) {
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }
                costSum -= runningCosts[left];
                left++;
            }

            maxRobots = Math.max(maxRobots, right - left + 1);
        }
        return maxRobots;
    }
}