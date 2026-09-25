// LeetCode 93: Restore IP Addresses
import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
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
}