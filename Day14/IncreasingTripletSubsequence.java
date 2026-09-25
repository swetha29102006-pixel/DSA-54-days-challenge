class Solution {
    /**
     * Checks if there exists an increasing triplet subsequence (i < j < k and nums[i] < nums[j] < nums[k]).
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num; // Smallest number seen so far
            } else if (num <= second) {
                second = num; // Second smallest number seen so far
            } else {
                // If number is greater than both first and second, triplet exists
                return true;
            }
        }

        return false;
    }
}