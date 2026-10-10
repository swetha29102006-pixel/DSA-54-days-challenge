import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 1425: Constrained Subsequence Sum
 * Return the maximum sum of a non-empty subsequence of nums such that for every two consecutive elements in subsequence, distance <= k.
 * Time Complexity: O(N) DP optimization with monotonic deque.
 * Space Complexity: O(N) for dp array and deque.
 */
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

    public static void main(String[] args) {
        ConstrainedSubsequenceSum solver = new ConstrainedSubsequenceSum();
        int[] nums = {10, 2, -10, 5, 20};
        System.out.println("Constrained Subsequence Sum: " + solver.constrainedSubsetSum(nums, 2)); // 37
    }
}