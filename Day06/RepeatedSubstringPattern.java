class Solution {
    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();

        for (int len = 1; len <= n / 2; len++) {

            if (n % len != 0) {
                continue;
            }

            String part = s.substring(0, len);
            boolean valid = true;

        }

        return false;
    }
}
