class Solution {
    public int[] mergeSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int left, int right) {
        
    }
}