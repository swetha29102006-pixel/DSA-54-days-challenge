import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RevealCardsInIncreasingOrder {
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
}