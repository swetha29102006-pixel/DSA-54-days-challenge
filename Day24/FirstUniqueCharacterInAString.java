import java.util.LinkedList;
import java.util.Queue;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
            queue.offer(i);

            while (!queue.isEmpty() && count[s.charAt(queue.peek()) - 'a'] > 1) {
                queue.poll();
            }
        }
        return queue.isEmpty() ? -1 : queue.peek();
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInAString solver = new FirstUniqueCharacterInAString();
        System.out.println("leetcode: " + solver.firstUniqChar("leetcode")); // 0
        System.out.println("loveleetcode: " + solver.firstUniqChar("loveleetcode")); // 2
    }
}