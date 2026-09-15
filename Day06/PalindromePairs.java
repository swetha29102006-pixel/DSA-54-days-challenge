class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {

        Map<String, Integer> wmap = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < words.length; i++)
            wmap.put(words[i], i);

        for (int i = 0; i < words.length; i++) {

            if (words[i].equals("")) {
                for (int j = 0; j < words.length; j++) {
                    String w = words[j];

                    if (isPal(w, 0, w.length() - 1) && j != i) {
                        ans.add(List.of(i, j));
                        ans.add(List.of(j, i));
                    }
                }
                continue;
            }

            StringBuilder sb = new StringBuilder(words[i]);
            sb.reverse();
            String bw = sb.toString();

            if (wmap.containsKey(bw)) {
                int res = wmap.get(bw);

                if (res != i)
                    ans.add(List.of(i, res));
            }
        }

    }
}
