class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = (high - low) / 2 + low;

            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, high);
        }
    }
}
