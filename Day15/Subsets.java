import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Generates all possible subsets (power set) using backtracking decision tree.
     * Time Complexity: O(n * 2^n)
     * Space Complexity: O(n) recursion depth space.
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]); // Make choice
            backtrack(result, current, nums, i + 1); // Recurse
            current.remove(current.size() - 1); // Backtrack choice
        }
    }
}