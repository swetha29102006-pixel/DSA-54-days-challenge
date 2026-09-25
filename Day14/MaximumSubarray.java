class Solution {
    /**
     * Kadane's Algorithm for finding maximum contiguous subarray sum.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to add current element to existing subarray or start fresh
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }
}