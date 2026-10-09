import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * LeetCode 950: Reveal Cards In Increasing Order
 * Reorder the deck so that revealing cards one by one produces cards in increasing order.
 * Time Complexity: O(N log N) for deck sorting.
 * Space Complexity: O(N) for index deque and result array.
 */
public class RevealCardsInIncreasingOrder {
    // Simulates index deque order for increasing card reveal order
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Deque<Integer> indexQueue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            indexQueue.add(i);
        }

        int[] result = new int[n];
        for (int card : deck) {
            result[indexQueue.poll()] = card;
            if (!indexQueue.isEmpty()) {
                indexQueue.add(indexQueue.poll());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RevealCardsInIncreasingOrder solver = new RevealCardsInIncreasingOrder();
        int[] res = solver.deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7});
        System.out.print("Revealed Deck: ");
        for (int x : res) System.out.print(x + " ");
        System.out.println();
    }
}