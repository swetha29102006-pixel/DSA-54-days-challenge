import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /**
     * Finds all unique triplets that sum to 0 using sorting and two pointers.
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) auxiliary space (ignoring output and sorting space).
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        // Sort array in O(n log n)
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // If current element is > 0, three positive numbers cannot sum to 0
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicate elements for the first triplet position
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for second and third elements
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}