class Solution {
    public int[] insertionSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int n = nums.length;

        // Build sorted prefix one element at a time
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;

            // Move elements greater than key one position ahead
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }

        return nums;
    }
}