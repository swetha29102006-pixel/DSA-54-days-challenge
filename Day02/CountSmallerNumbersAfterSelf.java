import java.util.*;

class Solution {
    int[] bit = new int[20002];

    void add(int i) {
        while (i < bit.length) {
            bit[i]++;
            i += i & -i;
        }
    }

    int sum(int i) {
        int s = 0;

        while (i > 0) {
            s += bit[i];
            i -= i & -i;
        }

        return s;
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] ans = new Integer[n];

        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i] + 10001;

            ans[i] = sum(x);
            add(x + 1);
        }

        return Arrays.asList(ans);
    }
}
