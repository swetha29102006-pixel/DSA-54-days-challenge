import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return new int[0];
        }

        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean exploded = false;

            // Collision only occurs if top asteroid moves right (+) and current moves left (-)
            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                if (stack.peek() < -ast) {
                    stack.pop();
                    continue; // Re-check collision with previous asteroid
                } else if (stack.peek() == -ast) {
                    stack.pop(); // Both destroy each other
                }
                exploded = true;
                break;
            }

            if (!exploded) {
                stack.push(ast);
            }
        }

        // Convert stack to array in proper order
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}