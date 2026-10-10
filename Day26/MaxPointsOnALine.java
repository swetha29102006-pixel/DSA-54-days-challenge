import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 149: Max Points on a Line
 * Return the maximum number of points that lie on the same 2D straight line.
 * Time Complexity: O(N^2) slope pairwise hashing.
 * Space Complexity: O(N) for slope frequency map per point.
 */
public class MaxPointsOnALine {
    // Computes max collinear 2D points using GCD slope fraction hashing to prevent precision collisions
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int n = points.length;
        if (n <= 2) return n;

        int maxPoints = 0;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int duplicate = 0;
            int localMax = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    duplicate++;
                    continue;
                }

                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;

                String slope = dy + "/" + dx;
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, map.get(slope));
            }

            maxPoints = Math.max(maxPoints, localMax + duplicate + 1);
        }
        return maxPoints;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        MaxPointsOnALine solver = new MaxPointsOnALine();
        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println("Max points on a line: " + solver.maxPoints(points)); // 3
    }
}