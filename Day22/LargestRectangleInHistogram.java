import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 84: Largest Rectangle in Histogram
 * Given an array of integers heights representing the histogram's bar height, return the area of the largest rectangle.
 * Time Complexity: O(N) single pass with stack.
 * Space Complexity: O(N) for monotonic height index stack.
 */
public class LargestRectangleInHistogram {
    // Calculates largest rectangle area in histogram using monotonic stack
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= currentHeight) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram solver = new LargestRectangleInHistogram();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Max Rectangle Area: " + solver.largestRectangleArea(heights)); // 10
    }
}