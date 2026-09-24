class Solution {
    public int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int n = nums.length;

        // Perform bubble sort with early exit optimization
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps occurred, array is already sorted
            if (!swapped) {
                break;
            }
        }

        return nums;
    }
}