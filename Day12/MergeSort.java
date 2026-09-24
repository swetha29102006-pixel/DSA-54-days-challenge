class Solution {
    /**
     * Merge Sort implementation using divide-and-conquer.
     * Time Complexity: O(n log n) in all cases.
     * Space Complexity: O(n) auxiliary space for merging.
     */
    public int[] mergeSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        // Merge two sorted halves into temporary buffer
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // Copy merged elements back to original array
        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
        }
    }
}