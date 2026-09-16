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

        int i = 0;
        int j = p.length() - 1;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int x = i; x <= j; x++) {
            map.put(
                s.charAt(x),
                map.getOrDefault(s.charAt(x), 0) + 1
            );
        }

        boolean isEqual = originalMap.equals(map);

        if (isEqual) {
            arr.add(i);
        }

        while (j < s.length() - 1) {

            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);

            if (map.get(s.charAt(i)) == 0) {
                map.remove(s.charAt(i));
            }

            i++;
            j++;

            map.put(
                s.charAt(j),
                map.getOrDefault(s.charAt(j), 0) + 1
            );

            boolean isEqual2 = originalMap.equals(map);

            if (isEqual2) {
                arr.add(i);
            }
        }

        return arr;
    }
}
