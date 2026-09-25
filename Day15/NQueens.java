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

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) {
                continue;
            }
            queens[row] = col;
            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);

            backtrack(result, queens, row + 1, n);

            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
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