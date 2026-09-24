class Solution {
    /**
     * Selection Sort implementation.
     * Time Complexity: O(n^2) for all cases.
     * Space Complexity: O(1) auxiliary space (in-place).
     */
    public int[] selectionSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int n = nums.length;

        // Move the boundary of the unsorted subarray one by one
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;

            // Find minimum element in unsorted subarray [i..n-1]
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }

            // Swap found minimum element with current element
            if (minIdx != i) {
                int temp = nums[minIdx];
                nums[minIdx] = nums[i];
                nums[i] = temp;
            }
        }

        return nums;
    }
}