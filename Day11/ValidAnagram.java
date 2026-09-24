class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        // Fixed-size frequency hash bucket for 26 lowercase English letters
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        // If all character frequencies balance out, strings are anagrams
        for (int f : freq) {
            if (f != 0) {
                return false;
            }
        }

        return true;
    }
}