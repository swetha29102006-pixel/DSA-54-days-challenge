import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 2398: Maximum Number of Robots Within Budget
 * Find maximum number of consecutive robots you can run such that total cost <= budget.
 * Time Complexity: O(N) sliding window with monotonic max deque.
 * Space Complexity: O(N) for deque.
 */
public class MaximumNumberOfRobotsWithinBudget {
    // Calculates max consecutive robots within budget using sliding window + max deque
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

    public static void main(String[] args) {
        MaximumNumberOfRobotsWithinBudget solver = new MaximumNumberOfRobotsWithinBudget();
        int[] chargeTimes = {3, 6, 1, 3, 4};
        int[] runningCosts = {2, 1, 3, 4, 5};
        long budget = 25;
        System.out.println("Max Robots: " + solver.maximumRobots(chargeTimes, runningCosts, budget)); // 3
    }
}