class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> m = new HashMap<>();
        int maxFreq = 0;
        int maxLen = 0;

        while (r < s.length()) {
            char ch = s.charAt(r);

            m.put(ch, m.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(m.get(ch), maxFreq);

            while ((r - l + 1) - maxFreq > k) {
                ch = s.charAt(l);
                m.put(ch, m.getOrDefault(ch, 0) - 1);
                l++;
            }

            maxLen = Math.max(r - l + 1, maxLen);
            r++;
        }

        return maxLen;
    }
}
