import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 454: 4Sum II
 * Given four integer arrays of length n, return number of tuples (i, j, k, l) such that nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0.
 * Time Complexity: O(N^2) where N is array length.
 * Space Complexity: O(N^2) for hash map storing pair sums.
 */
public class FourSumII {
    // Calculates total quadruplets that sum to 0 in O(N^2) using HashMap pairing
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int c : nums3) {
            for (int d : nums4) {
                int target = -(c + d);
                count += map.getOrDefault(target, 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FourSumII solver = new FourSumII();
        int[] nums1 = {1, 2}, nums2 = {-2, -1}, nums3 = {-1, 2}, nums4 = {0, 2};
        System.out.println("4Sum II Count: " + solver.fourSumCount(nums1, nums2, nums3, nums4)); // 2
    }
}