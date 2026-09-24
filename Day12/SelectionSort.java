class Solution {
    public int[] selectionSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int temp = nums[minIdx];
                nums[minIdx] = nums[i];
                nums[i] = temp;
            }
        }

        return nums;
    }
}