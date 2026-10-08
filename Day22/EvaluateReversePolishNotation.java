import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 150: Evaluate Reverse Polish Notation
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Time Complexity: O(N) where N is number of tokens.
 * Space Complexity: O(N) for operand stack.
 */
public class EvaluateReversePolishNotation {
    // Evaluates arithmetic expressions in Reverse Polish Notation using stack
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation solver = new EvaluateReversePolishNotation();
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println("RPN Result: " + solver.evalRPN(tokens)); // 9
    }
}