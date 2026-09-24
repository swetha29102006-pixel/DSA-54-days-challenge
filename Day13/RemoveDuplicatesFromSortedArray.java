class Solution {
    /**
     * Removes duplicates in-place from sorted array using two pointers.
     * Time Complexity: O(n)
     * Space Complexity: O(1) in-place
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Slow write pointer tracks boundary of unique prefix
        int writeIndex = 0;

        // Fast read pointer scans remaining elements
        for (int readIndex = 1; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != nums[writeIndex]) {
                writeIndex++;
                nums[writeIndex] = nums[readIndex];
            }
        }

        // Number of unique elements is writeIndex + 1
        return writeIndex + 1;
    }
}