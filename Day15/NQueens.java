import java.util.ArrayList;
import java.util.Arrays;
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
        if (row == n) {
            result.add(buildBoard(queens, n));
            return;
        }
    }

    private List<String> buildBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] r = new char[n];
            Arrays.fill(r, '.');
            r[queens[i]] = 'Q';
            board.add(new String(r));
        }
        return board;
    }
}