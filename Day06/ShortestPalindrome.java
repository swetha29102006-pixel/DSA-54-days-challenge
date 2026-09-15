class Solution {
    public String shortestPalindrome(String s) {

        String rev = new StringBuilder(s).reverse().toString();

        String combined = s + "#" + rev;

        int[] lps = new int[combined.length()];

    }
}
