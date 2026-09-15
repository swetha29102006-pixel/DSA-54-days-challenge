class Solution {
    public int countSubstrings(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            // Odd length palindrome
            count += expand(s, i, i);
        }

        return count;
    }

    private int expand(String s, int left, int right) {

        return 0;
    }
}
