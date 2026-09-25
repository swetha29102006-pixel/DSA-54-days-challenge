class Solution {
    /**
     * String to Integer (atoi) implementation with whitespace trimming, sign detection, and overflow clamping.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int index = 0;
        int n = s.length();

        // 1. Ignore leading whitespaces
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // 2. Determine sign
        int sign = 1;
        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // 3. Read digits and guard against 32-bit integer overflow
        int result = 0;
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }
}