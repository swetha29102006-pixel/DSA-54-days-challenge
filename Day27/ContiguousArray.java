import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    // Finds maximum length of contiguous subarray with equal number of 0s and 1s using prefix balance hashing
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        int balance = 0;

        for (int i = 0; i < nums.length; i++) {
            balance += (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(balance)) {
                maxLen = Math.max(maxLen, i - map.get(balance));
            } else {
                map.put(balance, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        ContiguousArray solver = new ContiguousArray();
        System.out.println("Max length [0, 1]: " + solver.findMaxLength(new int[]{0, 1})); // 2
        System.out.println("Max length [0, 1, 0]: " + solver.findMaxLength(new int[]{0, 1, 0})); // 2
    }
}