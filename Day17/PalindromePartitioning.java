// LeetCode 131: Palindrome Partitioning
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    /**
     * Partitions string s into all possible palindromic substrings.
     * Time Complexity: O(N * 2^N)
     * Space Complexity: O(N) for recursion stack.
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                current.add(s.substring(start, i + 1));
                backtrack(s, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning solver = new PalindromePartitioning();
        System.out.println("Partitions of 'aab': " + solver.partition("aab")); // Output: [["a","a","b"], ["aa","b"]]
    }
}