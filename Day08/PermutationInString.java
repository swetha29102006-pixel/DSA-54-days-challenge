class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int p[] = new int[26];
        int w[] = new int[26];
        int l = 0;
        int k = s1.length();

        for (int i = 0; i < k; i++) {
            char ch = s1.charAt(i);
            p[ch - 'a']++;
        }
    }
}
