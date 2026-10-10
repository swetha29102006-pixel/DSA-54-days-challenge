import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 128: Longest Consecutive Sequence
 * Given an unsorted array of integers, return length of longest consecutive elements sequence in O(N) time.
 * Time Complexity: O(N) single pass traversal over hash set.
 * Space Complexity: O(N) for storing elements in hash set.
 */
public class LongestConsecutiveSequence {
    // Finds length of longest consecutive elements sequence in O(N) using HashSet
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence solver = new LongestConsecutiveSequence();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive sequence: " + solver.longestConsecutive(nums)); // 4
    }
}