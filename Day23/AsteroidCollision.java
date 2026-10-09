import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

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

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        AsteroidCollision solver = new AsteroidCollision();
        int[] res = solver.asteroidCollision(new int[]{5, 10, -5});
        System.out.print("Remaining Asteroids: ");
        for (int a : res) System.out.print(a + " ");
        System.out.println();
    }
}