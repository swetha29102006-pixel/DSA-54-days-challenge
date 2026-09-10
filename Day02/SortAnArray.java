class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void mergeFun(int[] arr, int l, int m, int r) {
        int n1 = m + 1 - l;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = (high - low) / 2 + low;

            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, high);
        }
    }
}
