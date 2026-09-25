class Solution {
    /**
     * 2D Grid DFS backtracking word search.
     * Time Complexity: O(M * N * 3^L) where L is length of word.
     * Space Complexity: O(L) recursion stack.
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == word.charAt(0) && dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        if (index == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }

        // Mark cell visited
        char temp = board[r][c];
        board[r][c] = '#';

        // Recurse in 4 directions
        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                        dfs(board, word, r - 1, c, index + 1) ||
                        dfs(board, word, r, c + 1, index + 1) ||
                        dfs(board, word, r, c - 1, index + 1);

        // Restore cell state
        board[r][c] = temp;
        return found;
    }
}