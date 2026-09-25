// LeetCode 40: Combination Sum II
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    /**
     * Finds unique combinations that sum to target using candidates at most once.
     * Time Complexity: O(2^N)
     * Space Complexity: O(N) for recursion stack.
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumII solver = new CombinationSumII();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println("Combinations: " + solver.combinationSum2(candidates, 8)); // Output: [[1,1,6], [1,2,5], [1,7], [2,6]]
    }
}