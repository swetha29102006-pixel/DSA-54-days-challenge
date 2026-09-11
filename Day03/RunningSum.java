class Solution {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int previous = nums[i - 1];
            int current = nums[i];

            nums[i] = current + previous;
        }

        return nums;
    }
}
