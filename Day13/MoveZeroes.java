class Solution {
    /**
     * Moves all zeroes to end while maintaining relative order of non-zero elements.
     * Time Complexity: O(n)
     * Space Complexity: O(1) in-place
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        // Left pointer marks insertion position for the next non-zero element
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                // Swap non-zero element with element at left pointer
                if (left != right) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
                left++;
            }
        }
    }
}