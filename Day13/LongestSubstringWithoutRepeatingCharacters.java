import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * Finds length of longest substring without repeating characters using sliding window.
     * Time Complexity: O(n)
     * Space Complexity: O(min(m, n)) where m is size of alphabet.
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLen = 0;
        int left = 0;
        // Map to store last seen index of each character
        Map<Character, Integer> lastSeen = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If character has been seen within current window, adjust left boundary
            if (lastSeen.containsKey(c)) {
                left = Math.max(left, lastSeen.get(c) + 1);
            }

            lastSeen.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}