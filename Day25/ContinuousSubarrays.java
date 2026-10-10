import java.util.ArrayDeque;
import java.util.Deque;

public class ContinuousSubarrays {
    // Counts total continuous subarrays where max - min <= 2 using dual deques
    public long continuousSubarrays(int[] nums) {
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        int left = 0;
        long count = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            maxDeque.addLast(right);
            minDeque.addLast(right);

            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > 2) {
                if (maxDeque.peekFirst() == left) maxDeque.pollFirst();
                if (minDeque.peekFirst() == left) minDeque.pollFirst();
                left++;
            }

            count += (right - left + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        ContinuousSubarrays solver = new ContinuousSubarrays();
        System.out.println("Continuous Subarrays: " + solver.continuousSubarrays(new int[]{5, 4, 2, 4})); // 8
    }
}