import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode 432: All Oone Data Structure
 * Design a data structure to store key counts with O(1) Inc, Dec, GetMaxKey, and GetMinKey.
 * Time Complexity: O(1) for all operations using Doubly Linked List of Frequency Buckets.
 * Space Complexity: O(K) where K is number of unique keys.
 */
class BucketNode {
    int count;
    Set<String> keys;
    BucketNode prev;
    BucketNode next;

    BucketNode(int count) {
        this.count = count;
        this.keys = new HashSet<>();
    }
}

public class AllOoneDataStructure {
    private final BucketNode head;
    private final BucketNode tail;
    private final Map<String, Integer> keyCount;
    private final Map<Integer, BucketNode> countBucket;

    public AllOoneDataStructure() {
        head = new BucketNode(0);
        tail = new BucketNode(0);
        head.next = tail;
        tail.prev = head;
        keyCount = new HashMap<>();
        countBucket = new HashMap<>();
    }

    private BucketNode addBucketAfter(BucketNode newBucket, BucketNode prevBucket) {
        newBucket.next = prevBucket.next;
        newBucket.prev = prevBucket;
        prevBucket.next.prev = newBucket;
        prevBucket.next = newBucket;
        countBucket.put(newBucket.count, newBucket);
        return newBucket;
    }

    private void removeBucket(BucketNode bucket) {
        bucket.prev.next = bucket.next;
        bucket.next.prev = bucket.prev;
        countBucket.remove(bucket.count);
    }

    public void inc(String key) {
        int count = keyCount.getOrDefault(key, 0);
        keyCount.put(key, count + 1);

        BucketNode curBucket = countBucket.get(count);
        BucketNode nextBucket = countBucket.get(count + 1);

        if (nextBucket == null) {
            nextBucket = addBucketAfter(new BucketNode(count + 1), curBucket == null ? head : curBucket);
        }
        nextBucket.keys.add(key);

        if (curBucket != null) {
            curBucket.keys.remove(key);
            if (curBucket.keys.isEmpty()) {
                removeBucket(curBucket);
            }
        }
    }

    public void dec(String key) {
        if (!keyCount.containsKey(key)) return;
        int count = keyCount.get(key);

        BucketNode curBucket = countBucket.get(count);
        curBucket.keys.remove(key);

        if (count == 1) {
            keyCount.remove(key);
        } else {
            keyCount.put(key, count - 1);
            BucketNode prevBucket = countBucket.get(count - 1);
            if (prevBucket == null) {
                prevBucket = addBucketAfter(new BucketNode(count - 1), curBucket.prev);
            }
            prevBucket.keys.add(key);
        }

        if (curBucket.keys.isEmpty()) {
            removeBucket(curBucket);
        }
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    public static void main(String[] args) {
        AllOoneDataStructure allOne = new AllOoneDataStructure();
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println("Max Key: " + allOne.getMaxKey()); // hello
        System.out.println("Min Key: " + allOne.getMinKey()); // hello
        allOne.inc("leet");
        System.out.println("Max Key: " + allOne.getMaxKey()); // hello
        System.out.println("Min Key: " + allOne.getMinKey()); // leet
    }
}