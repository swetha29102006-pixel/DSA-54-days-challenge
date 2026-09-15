class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, 0);
    }

    boolean wordBreak(String s, List<String> wordDict, int k) {
        if (k == s.length()) {
            return true;
        }

        return false;
    }
}
