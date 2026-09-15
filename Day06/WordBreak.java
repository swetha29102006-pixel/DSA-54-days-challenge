class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, 0);
    }

    boolean wordBreak(String s, List<String> wordDict, int k) {
        if (k == s.length()) {
            return true;
        }

        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);

            if (s.startsWith(word, k)) {
                if (wordBreak(s, wordDict, k + word.length())) {
                    return true;
                }
            }
        }

        return false;
    }
}
