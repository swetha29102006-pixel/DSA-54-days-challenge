/**
 * LeetCode 299: Bulls and Cows
 * Provide hints for the Bulls and Cows game where bulls are exact matches and cows are digits in the wrong position.
 * Time Complexity: O(N) single pass through the strings.
 * Space Complexity: O(1) fixed 10 digit frequency tracker.
 */
public class BullsAndCows {
    // Calculates bulls (exact position matches) and cows (misplaced matches) using two-way frequency hashing
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] count = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) {
                bulls++;
            } else {
                if (count[s] < 0) cows++;
                count[s]++;
                if (count[g] > 0) cows++;
                count[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        BullsAndCows solver = new BullsAndCows();
        System.out.println("Hint (1807, 7810): " + solver.getHint("1807", "7810")); // 1A3B
        System.out.println("Hint (1123, 0111): " + solver.getHint("1123", "0111")); // 1A1B
    }
}