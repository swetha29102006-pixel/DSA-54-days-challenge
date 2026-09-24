class Solution {
    /**
     * Quick Sort implementation using Lomuto partition scheme.
     * Time Complexity: O(n log n) average, O(n^2) worst case.
     * Space Complexity: O(log n) recursion stack space.
     */
    public int[] quickSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int low, int high) {
        if (low < high) {
            // Find pivot element such that elements smaller than pivot are on left
            int pIndex = partition(nums, low, high);

            // Recursively sort left and right partitions
            sort(nums, low, pIndex - 1);
            sort(nums, pIndex + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, high);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}