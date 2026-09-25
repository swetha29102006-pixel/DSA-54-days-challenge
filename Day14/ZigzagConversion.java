import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Zigzag String conversion algorithm simulating row movement.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1 || s.length() <= numRows) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        // Bounce between row 0 and row numRows - 1
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}