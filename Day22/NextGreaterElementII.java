import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * LeetCode 503: Next Greater Element II
 * Find the next greater number for every element in a circular array.
 * Time Complexity: O(N) where N is length of array.
 * Space Complexity: O(N) for monotonic stack.
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                res[stack.pop()] = nums[i % n];
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterElementII solver = new NextGreaterElementII();
        int[] res = solver.nextGreaterElements(new int[]{1, 2, 1});
        System.out.print("Circular Next Greater: ");
        for (int x : res) System.out.print(x + " ");
        System.out.println();
    }
}