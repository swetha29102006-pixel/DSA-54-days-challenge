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
}