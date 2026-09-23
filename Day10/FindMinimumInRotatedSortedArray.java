class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        // Binary search for the inflection point in O(log n)
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Minimum must be in the right unsorted part
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Minimum is at mid or in the left part
                right = mid;
            }
        }

        return nums[left];
    }
}