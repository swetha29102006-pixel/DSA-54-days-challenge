import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Generates all combinations of well-formed parentheses using constrained backtracking.
     * Time Complexity: O(4^n / sqrt(n)) - n-th Catalan number.
     * Space Complexity: O(n) recursion stack space.
     */
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // Base case: valid parenthesized string of length 2*n reached
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        if (open < max) {
            current.append('(');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }

        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }
}