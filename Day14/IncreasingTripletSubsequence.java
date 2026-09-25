class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num; // smallest element seen so far
            } else if (num <= second) {
                second = num; // second smallest element seen so far
            } else {
                // Found element greater than both first and second
                return true;
            }
        }

        return false;
    }
}