import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean exploded = false;
            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                if (stack.peek() < -ast) {
                    stack.pop();
                    continue;
                } else if (stack.peek() == -ast) {
                    stack.pop();
                }
                exploded = true;
                break;
            }

            if (!exploded) {
                stack.push(ast);
            }
        }

        return new int[0];
    }
}