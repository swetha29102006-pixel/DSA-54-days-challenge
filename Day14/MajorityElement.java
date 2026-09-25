class Solution {
    /**
     * Boyer-Moore Majority Vote Algorithm.
     * Finds element appearing more than n/2 times.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}