import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 20: Valid Parentheses
 * Determine if an input string containing '(', ')', '{', '}', '[' and ']' is valid.
 * Time Complexity: O(N) single scan of string.
 * Space Complexity: O(N) for character stack.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) return false;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses solver = new ValidParentheses();
        System.out.println("()[]{}: " + solver.isValid("()[]{}")); // true
        System.out.println("(]: " + solver.isValid("(]"));         // false
    }
}