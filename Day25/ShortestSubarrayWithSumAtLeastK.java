import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 862: Shortest Subarray with Sum at Least K
 * Return the length of the shortest non-empty subarray of nums with sum at least k.
 * Time Complexity: O(N) single pass with monotonic deque.
 * Space Complexity: O(N) for prefix sum array and deque.
 */
public class ShortestSubarrayWithSumAtLeastK {
    // Finds shortest non-empty subarray with sum at least K using prefix sum + monotonic deque
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] P = new long[n + 1];
        for (int i = 0; i < n; i++) {
            P[i + 1] = P[i] + nums[i];
        }

        int ans = n + 1;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && P[i] - P[deque.peekFirst()] >= k) {
                ans = Math.min(ans, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && P[i] <= P[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }

        return ans <= n ? ans : -1;
    }

    public static void main(String[] args) {
        ShortestSubarrayWithSumAtLeastK solver = new ShortestSubarrayWithSumAtLeastK();
        System.out.println("Shortest subarray sum >= 3: " + solver.shortestSubarray(new int[]{2, -1, 2}, 3)); // 3
    }
}