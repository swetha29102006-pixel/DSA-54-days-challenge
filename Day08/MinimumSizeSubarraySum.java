class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int curSum = 0;

        for (int right = 0; right < nums.length; right++) {

            // Expand window
            curSum += nums[right];

            // Shrink window while sum is enough
            while (curSum >= target) {

                minLen = Math.min(minLen, right - left + 1);

                curSum -= nums[left];
                left++;
            }
        }

        // Return 0 if no valid subarray exists
        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }
}
