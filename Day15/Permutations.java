import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        // Generate permutations via recursive backtracking
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums) {
        // Base case: full permutation formed
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (current.contains(num)) {
                continue; // Skip already chosen elements
            }
            current.add(num);
            backtrack(result, current, nums);
            current.remove(current.size() - 1); // Undo choice
        }
    }
}