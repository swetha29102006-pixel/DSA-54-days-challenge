class Solution {
    /**
     * Bubble Sort implementation with early exit optimization.
     * Time Complexity: O(n^2) worst/average, O(n) best case.
     * Space Complexity: O(1) auxiliary space.
     */
    public int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int n = nums.length;

        // Traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            // Last i elements are already in place
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }

            // Early exit if array is already sorted
            if (!swapped) {
                break;
            }
        }

        return nums;
    }
}