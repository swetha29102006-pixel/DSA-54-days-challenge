import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 560: Subarray Sum Equals K
 * Return the total number of continuous subarrays whose sum equals to k.
 * Time Complexity: O(N) single pass with prefix sum hash map.
 * Space Complexity: O(N) for hash map prefix frequency lookup.
 */
public class SubarraySumEqualsK {
    // Calculates total continuous subarrays whose sum equals K using prefix sum hash map
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solver = new SubarraySumEqualsK();
        System.out.println("Subarray sum equals 2: " + solver.subarraySum(new int[]{1, 1, 1}, 2)); // 2
        System.out.println("Subarray sum equals 3: " + solver.subarraySum(new int[]{1, 2, 3}, 3)); // 2
    }
}