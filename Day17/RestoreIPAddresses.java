// LeetCode 93: Restore IP Addresses
import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    /**
     * Partitions digit string into all possible valid IPv4 addresses.
     * Time Complexity: O(3^4) = O(81) ~ O(1) constant search space.
     * Space Complexity: O(1) max recursion depth 4.
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, "", result);
        return result;
    }

    private void backtrack(String s, int index, int dots, String current, List<String> result) {
        if (dots == 4 && index == s.length()) {
            result.add(current.substring(0, current.length() - 1));
            return;
        }
        if (dots > 4) return;

        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) break;
            String segment = s.substring(index, index + i);
            if ((segment.startsWith("0") && segment.length() > 1) || Integer.parseInt(segment) > 255) {
                continue;
            }
            backtrack(s, index + i, dots + 1, current + segment + ".", result);
        }
    }

    public static void main(String[] args) {
        RestoreIPAddresses solver = new RestoreIPAddresses();
        System.out.println("Valid IPs for '25525511135': " + solver.restoreIpAddresses("25525511135")); // Output: ["255.255.11.135", "255.255.111.35"]
    }
}