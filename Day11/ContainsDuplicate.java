import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        // HashSet enables O(1) average lookup and insertion
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            // Set.add() returns false if the item is already present
            if (!seen.add(num)) {
                return true;
            }
        }

        return false;
    }
}