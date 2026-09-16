class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        HashMap<Character, Integer> originalMap = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();

        if (p.length() > s.length()) {
            return arr;
        }

        for (int i = 0; i < p.length(); i++) {
            originalMap.put(
                p.charAt(i),
                originalMap.getOrDefault(p.charAt(i), 0) + 1
            );
        }

        return arr;
    }
}
