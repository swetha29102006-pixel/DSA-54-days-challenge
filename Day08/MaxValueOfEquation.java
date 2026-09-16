class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int ans = Integer.MIN_VALUE;
        int i = 0;
        int f = 1;

        while (i < points.length) {
            if (f < i + 1) {
                f = i + 1;
            }

            i++;
        }

        return ans;
    }
}
