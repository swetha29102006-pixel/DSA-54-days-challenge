class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        // Binary search based on even/odd index parity in O(log n)
        while (left < right) {
            int mid = left + (right - left) / 2;
            // Ensure mid is even
            if (mid % 2 == 1) {
                mid--;
            }

            // If pair starts at even index, unique element is to the right
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}