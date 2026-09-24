import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            // seen.add returns false if element was already present
            if (!seen.add(num)) {
                return true;
            }
        }

        return false;
    }
}