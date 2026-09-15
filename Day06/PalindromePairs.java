class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {

        Map<String, Integer> wmap = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < words.length; i++)
            wmap.put(words[i], i);

    }
}
