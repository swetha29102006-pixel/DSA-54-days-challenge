class Solution {
    /**
     * Insertion Sort implementation.
     * Time Complexity: O(n^2) worst/average, O(n) best case (nearly sorted).
     * Space Complexity: O(1) auxiliary space (in-place & stable).
     */
    public int[] insertionSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int n = nums.length;

        // Iterate through elements starting from second element
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;

            // Shift elements of nums[0..i-1] that are greater than key to the right
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }

        return nums;
    }
}