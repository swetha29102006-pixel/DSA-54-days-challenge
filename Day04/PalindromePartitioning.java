class Solution {

    private boolean isPalindrome(String s, int start, int end) {

        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
}
