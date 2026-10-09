/**
 * LeetCode 1047: Remove All Adjacent Duplicates In String
 * Repeatedly choose two adjacent and equal letters and remove them.
 * Time Complexity: O(N) single pass across string.
 * Space Complexity: O(N) for StringBuilder stack.
 */
public class RemoveAllAdjacentDuplicatesInString {
    // Repeatedly removes adjacent duplicate characters using string stack
    public String removeDuplicates(String s) {
        if (s == null || s.isEmpty()) return s;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int len = sb.length();
            if (len > 0 && sb.charAt(len - 1) == c) {
                sb.deleteCharAt(len - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString solver = new RemoveAllAdjacentDuplicatesInString();
        System.out.println("abbaca -> " + solver.removeDuplicates("abbaca")); // ca
        System.out.println("azxxzy -> " + solver.removeDuplicates("azxxzy")); // ay
    }
}