import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 649: Dota2 Senate
 * Predict which party will announce victory in round-robin voting using queues.
 * Time Complexity: O(N) where N is senate string length.
 * Space Complexity: O(N) for radiant and dire index queues.
 */
public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();
            if (rIndex < dIndex) {
                radiant.add(rIndex + n);
            } else {
                dire.add(dIndex + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        Dota2Senate solver = new Dota2Senate();
        System.out.println("RD: " + solver.predictPartyVictory("RD"));   // Radiant
        System.out.println("RDD: " + solver.predictPartyVictory("RDD")); // Dire
    }
}