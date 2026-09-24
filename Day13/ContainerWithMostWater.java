class Solution {
    /**
     * Finds maximum container water using two-pointer technique.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        // Converge two pointers inward from both ends
        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(maxWater, currentArea);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}