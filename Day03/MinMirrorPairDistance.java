import java.util.*;

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        int n = nums.length;
        map.put(nums[n - 1], n - 1);

        for (int i = n - 2; i >= 0; i--) {
            int rev = reverse(nums[i]);
        }

        return -1;
    }

    public int reverse(int n) {
        int t = 0;

        while (n > 0) {
            t *= 10;
            t += n % 10;
            n /= 10;
        }

        return t;
    }
}
