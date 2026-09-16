class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> m = new HashMap<>();
        int maxLen = 0;

        while (r < s.length()) {
            char ch = s.charAt(r);
            m.put(ch, m.getOrDefault(ch, 0) + 1);

            r++;
        }

        return maxLen;
    }
}
