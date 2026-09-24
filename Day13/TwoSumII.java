class Solution {
    /**
     * Two Sum II - Input Array Is Sorted (1-indexed).
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[0];
        }

        int left = 0;
        int right = numbers.length - 1;

        // Converging two pointers from opposite ends
        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // 1-based indices per problem description
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[0];
    }
}