import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    // Computes distance to next warmer temperature for each day
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        DailyTemperatures solver = new DailyTemperatures();
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = solver.dailyTemperatures(temps);
        System.out.print("Days to warmer temp: ");
        for (int d : res) System.out.print(d + " ");
        System.out.println();
    }
}