import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 42: Trapping Rain Water
 * Compute how much water it can trap after raining using a monotonic stack.
 * Time Complexity: O(N) single pass over height array.
 * Space Complexity: O(N) for monotonic index stack.
 */
public class TrappingRainWater {
    // Calculates trapped rainwater volume using monotonic stack
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int water = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                water += distance * boundedHeight;
            }
            stack.push(i);
        }
        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater solver = new TrappingRainWater();
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped Water: " + solver.trap(heights)); // 6
    }
}