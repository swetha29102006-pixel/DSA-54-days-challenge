import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 227: Basic Calculator II
 * Evaluate a mathematical expression string containing non-negative integers and +, -, *, / operators.
 * Time Complexity: O(N) single pass string parsing.
 * Space Complexity: O(N) for stack storing operands.
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int currentNumber = 0;
        char operation = '+';
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        BasicCalculatorII calc = new BasicCalculatorII();
        System.out.println("3+2*2 = " + calc.calculate("3+2*2")); // 7
        System.out.println(" 3/2  = " + calc.calculate(" 3/2 ")); // 1
    }
}