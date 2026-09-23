class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }

        result[0] = findBound(nums, target, true);

        return result;
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        return -1;
    }
}