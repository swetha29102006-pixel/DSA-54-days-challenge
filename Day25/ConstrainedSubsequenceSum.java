import java.util.ArrayDeque;
import java.util.Deque;

public class ConstrainedSubsequenceSum {
    // Calculates max constrained subsequence sum where distance between indices <= k using DP + Deque
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        int maxSum = nums[0];

        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }
            dp[i] = nums[i] + (deque.isEmpty() ? 0 : Math.max(0, dp[deque.peekFirst()]));
            maxSum = Math.max(maxSum, dp[i]);

            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return maxSum;
    }
}