import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * LeetCode 380: Insert Delete GetRandom O(1)
 * Implement the RandomizedSet class with average O(1) time for insert, remove, and getRandom.
 * Time Complexity: O(1) average time for all operations.
 * Space Complexity: O(N) for hash map and dynamic list storage.
 */
public class InsertDeleteGetRandomO1 {
    // RandomizedSet data structure supporting O(1) insert, delete, and getRandom
    private final Map<Integer, Integer> map;
    private final List<Integer> list;
    private final Random rand;

    public InsertDeleteGetRandomO1() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);

        list.set(index, lastElement);
        map.put(lastElement, index);

        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        InsertDeleteGetRandomO1 randomizedSet = new InsertDeleteGetRandomO1();
        System.out.println("insert 1: " + randomizedSet.insert(1)); // true
        System.out.println("remove 2: " + randomizedSet.remove(2)); // false
        System.out.println("insert 2: " + randomizedSet.insert(2)); // true
        System.out.println("getRandom: " + randomizedSet.getRandom());
        System.out.println("remove 1: " + randomizedSet.remove(1)); // true
        System.out.println("insert 2: " + randomizedSet.insert(2)); // false
        System.out.println("getRandom: " + randomizedSet.getRandom());
    }
}