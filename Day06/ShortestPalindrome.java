class Solution {
    public String shortestPalindrome(String s) {

        String rev = new StringBuilder(s).reverse().toString();

        String combined = s + "#" + rev;

        int[] lps = new int[combined.length()];

        for (int i = 1; i < combined.length(); i++) {

            int j = lps[i - 1];

        }

    }
}
