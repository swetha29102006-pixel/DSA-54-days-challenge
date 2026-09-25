import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> diag1 = new HashSet<>();
    private Set<Integer> diag2 = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n];
        backtrack(result, queens, 0, n);
        return result;
    }

    private void backtrack(List<List<String>> result, int[] queens, int row, int n) {

    }
}