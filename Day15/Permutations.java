import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Generates all distinct permutations using backtracking.
     * Time Complexity: O(n * n!)
     * Space Complexity: O(n) recursion depth space.
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums) {
        // Base case: permutation complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (current.contains(num)) {
                continue;
            }
            current.add(num); // Select
            backtrack(result, current, nums); // Recurse
            current.remove(current.size() - 1); // Backtrack
        }
    }
}