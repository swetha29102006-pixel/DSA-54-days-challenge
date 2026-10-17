public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (char c : magazine.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--counts[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote solver = new RansomNote();
        System.out.println("canConstruct('a', 'b'): " + solver.canConstruct("a", "b")); // false
        System.out.println("canConstruct('aa', 'aab'): " + solver.canConstruct("aa", "aab")); // true
    }
}