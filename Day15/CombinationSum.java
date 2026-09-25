import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        // Sort candidates to allow early pruning
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int remain, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Prune search tree if candidate exceeds remaining target
            if (candidates[i] > remain) {
                break;
            }
            current.add(candidates[i]);
            // Pass i (not i + 1) to allow repeated choice of same candidate
            backtrack(result, current, candidates, remain - candidates[i], i);
            current.remove(current.size() - 1);
        }
    }
}